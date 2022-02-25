package org.corejavavolume.concurrent.blockingqueue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 生产者线程集
 */
public class ProduceThreads {
    private final int I_ZH_ZYXMKXZFSQ = 100;

    public String sendThreadToQueue(Thread thread){
        return thread.getName();
    }

    public void madeSomeThreads(){
        Runnable r = () -> {
            ProduceThreads  produceThreads = new ProduceThreads();
        };
    }
}
