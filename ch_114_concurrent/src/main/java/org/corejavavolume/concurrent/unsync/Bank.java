package org.corejavavolume.concurrent.unsync;

import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private final double[] accounts;

    public Bank(int n, double initialBalance){
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    /**
     * transfers money from one to another
     * @param from money from
     * @param to money to
     * @param amount money amount
     */
    public void transfer(int from, int to, double amount){
        if (accounts[from] < amount) return;
        accounts[from] -= amount;
        System.out.printf(Thread.currentThread().getName() + " %10.2f from %d to %d."+System.lineSeparator(), amount, from, to);
        accounts[to] += amount;
        System.out.printf(Thread.currentThread().getName() + " Total balance is : %10.2f%n"+System.lineSeparator(), getTotalBalance());
    }

    public double getTotalBalance(){
        return Arrays.stream(accounts).sum();
    }

    public int size(){
        return accounts.length;
    }
}
