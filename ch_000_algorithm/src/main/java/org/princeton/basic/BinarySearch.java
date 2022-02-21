package org.princeton.basic;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * 二进制查找
 */
public class BinarySearch {

    public static int rank(int key, int[] a){
        int lo = 0;//最小序号
        int hi = a.length - 1; //最大序号
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;//中间序号：
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] whitelist = In.readInts(args[0]);
        Arrays.sort(whitelist);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (rank(key, whitelist) == -1) {
                StdOut.println(key);
            }
        }
    }
}
