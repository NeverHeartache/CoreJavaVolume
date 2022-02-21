package org.corejavavolume.concurrent.atomic;

/**
 * 验证-原子性 略
 * 这个验证不知道该怎么写，等以后来写吧
 *
 */
public class AtomicTemplate {

    public void unatomicAdd() {
        System.out.println(Thread.currentThread().getName() + "  AtomicConstant is : " + AtomicConstant.shared++);
    }

    public static void main(String[] args) {
        Runnable runnable = () -> {
            AtomicTemplate at = new AtomicTemplate();
            at.unatomicAdd();
        };
        int c = 20;
        for (int i = 0; i < 20; i++) {
            Thread t = new Thread(runnable);
            t.start();
        }
    }
}

class AtomicConstant {
    public static volatile int shared = 0;
}