package org.corejavavolume.concurrent.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.function.DoublePredicate;

/**
 * 生成一个大小为10_000_000的数组，使用Math.random()初始化该数组
 * 判断该数组中所有x>0.5的数值有多少个并求和
 * 该程序第一次运行结果为：4999277
 * 第二次结果为：5003955
 * 长此以往的结果，所有结果的平均值应该为5000000
 */
public class ForkJoinFrame {
    public static void main(String[] args) {
        final int SIZE = 10_000_000;
        double[] numbers = new double[SIZE];
        for (int i = 0; i < SIZE; i++) numbers[i] = Math.random();
        Counter counter = new Counter(numbers, 0, numbers.length, x -> x > 0.5);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(counter);
        System.out.println(counter.join());
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
                if (filter.test(values[i])) count++;
            }
            return count;
        } else {
            int mid = (from + to) / 2;
            Counter first = new Counter(values, from, mid, filter);
            Counter second = new Counter(values, mid, to, filter);
            invokeAll(first, second);
            return first.join() + second.join();
        }
    }
}
