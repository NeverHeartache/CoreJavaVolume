package org.corejavavolume.concurrent.basic;

import java.util.Vector;

public class BasicThread {
    public static void main(String[] args) {
        Runnable r = () -> {
            SyncronizedBlock sb = new SyncronizedBlock();
            sb.blockTest();
        };
        for (int i=0; i< 1000; i++) {
            Thread t = new Thread(r);
            t.start();
        }
        Vector vector = new Vector();
    }
}
class SyncronizedBlock {
    private Object lock = new Object();
    public void blockTest() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " This is unsync code.(非同步代码)");
        synchronized(lock) {
            System.out.println(threadName + " : This is sync code.（同步代码我恁爹）");
            System.out.println(threadName + " : This is sync code.（同步代码我恁爹）");
            System.out.println(threadName + " : This is sync code.（同步代码我恁爹）");
        }
        System.out.println(threadName + " This is unsync code.（非同步代码）");
    }
}
