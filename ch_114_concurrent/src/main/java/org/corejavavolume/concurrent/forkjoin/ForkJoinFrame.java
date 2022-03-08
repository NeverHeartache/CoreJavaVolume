package org.corejavavolume.concurrent.forkjoin;

import java.util.concurrent.RecursiveTask;
import java.util.function.DoublePredicate;

public class ForkJoinFrame {
    public static void main(String[] args) {
        final int SIZE = 10_000_000;
        double[] numbers = new double[SIZE];
        for (int i = 0; i < SIZE; i++) numbers[i] = Math.random();

    }
}
class Counter extends RecursiveTask<Integer> {
    public static final int THRESHOLD = 1000;
    private double[] values;
    private int from;
    private int to;
    private DoublePredicate filter;

    public Counter(double[] values, int from, int to, DoublePredicate filter){
        this.values = values;
        this.from = from;
        this.to = to;
        this.filter = filter;
    }

    @Override
    protected Integer compute() {
        if (to - from < THRESHOLD) {
            int count = 0;
            for (int i = from; i < to; i++){

            }
        }
        return null;
    }
}
