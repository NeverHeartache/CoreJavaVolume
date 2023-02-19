import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目要求：  设计四个线程，对
 */
public class JIncDec {
    private static volatile int j;
    private static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) {
        Runnable inc = () -> {
            for (int i = 0; i < 100; i++) {
                lock.lock();
                try {
                    j++;
                    System.out.println(Thread.currentThread().getName() + "-增加" + j);
                } finally {
                    lock.unlock();
                }
                Thread.yield();
            }
        };
        Runnable dec = () -> {
            for (int i = 0; i < 100; i++) {
                lock.lock();
                try {
                    j--;
                    System.out.println(Thread.currentThread().getName() + "-减少" + j);
                } finally {
                    lock.unlock();
                }
                Thread.yield();
            }
        };
        Thread t1 = new Thread(inc);
        Thread t2 = new Thread(inc);
        Thread t3 = new Thread(dec);
        Thread t4 = new Thread(dec);

        t1.start();
        t4.start();
        t2.start();
        t3.start();
    }
}
