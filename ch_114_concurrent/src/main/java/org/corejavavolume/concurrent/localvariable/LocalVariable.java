package org.corejavavolume.concurrent.localvariable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 */
public class LocalVariable {
    public static void main(String[] args) {
        Runnable r = () -> {
            System.out.println(ThreadId.getFormatTime() + " -- " + Thread.currentThread().getName() + " -- " + ThreadId.get());
        };
        for (int i = 0; i < 20_000; i++) {
            Thread thread = new Thread(r);
            thread.start();
        }
    }
}

class ThreadId {
    private ReentrantLock lock;
    // Atomic integer containing the next thread ID to be assigned
    private static final AtomicInteger nextId = new AtomicInteger(0);
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final ThreadLocal<SimpleDateFormat> sdfLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    // Thread local variable containing each thread's ID
    private static final ThreadLocal<Integer> threadId =
            new ThreadLocal<Integer>() {
                @Override protected Integer initialValue() {
                    return nextId.getAndIncrement();
                }
            };

    // Returns the current thread's unique ID, assigning it if necessary
    public static int get() {
        return threadId.get();
    }

    public static String getFormatTime() {
        return sdf.format(new Date());
    }

    public static String getConcurrentFormatTime() {
        return sdfLocal.get().format(new Date());
    }
}
