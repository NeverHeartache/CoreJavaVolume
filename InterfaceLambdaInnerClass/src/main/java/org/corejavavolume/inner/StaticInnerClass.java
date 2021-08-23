package org.corejavavolume.inner;


/**
 * This program demonstrates the use of static inner classes ,
 * @version 1.0.1
 * @author Cay Horstmann
 */
public class StaticInnerClass {
    public static void main(String[] args) {
        double[] d = new double[20];
        for (int i=0;i<20;i++) {
            d[i] = 100 * Math.random();
            System.out.println(d[i]);
        }
        ArrayAlg.Pair pair = ArrayAlg.minmax(d);
        System.out.println("最小值："+pair.getMin());
        System.out.println("最大值："+pair.getMax());
    }
}

class ArrayAlg{
    public static class Pair{
        private double min;
        private double max;

        public Pair(double f, double d){
            this.min = f;
            this.max = d;
        }

        public double getMin() {
            return min;
        }

        public double getMax() {
            return max;
        }
    }

    public static Pair minmax(double[] array){
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;
        for (double v : array){
            if (min > v) min = v;
            if (max < v) max = v;
        }

        return new Pair(min, max);
    }
}
