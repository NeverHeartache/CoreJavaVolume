package org.corejavavolume.concurrent.forkjoin;

import java.util.concurrent.RecursiveTask;

public class ForkJoinFrame {
    public static void main(String[] args) {
        final int SIZE = 10_000_000;
        double[] numbers = new double[SIZE];
        for (int i=0; i < SIZE; i++) numbers[i] = Math.random();
//        Counter counter
    }
}
class Counter extends RecursiveTask<Integer> {
    public static final int THRESHOLD = 1000;

    @Override
    protected Integer compute() {
        return null;
    }
}
