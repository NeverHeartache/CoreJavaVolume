package org.princeton.basic.chapter1_1;

public class JudgePrimeNumber {

    /**
     * judge a num if a prime,the conception is : 一个大于1的整数,除了1和它本身,不能被其他的数整除
     * 如果N < 2,N 不是素数
     * 如果N >= 2, 则
     * @param N
     * @return
     */
    private static boolean isPrime(int N) {
        if (N < 2) return false;
        for (int i = 2; i * i <= N; i++) {
            System.out.printf("The value of i is %d.\n", i);
            if (N % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int N = (int) (Math.random() * 1000);
        boolean isPrime = isPrime(7);
        System.out.printf("%d is/or not is prime? The answer is %b.", N,   isPrime);
    }
}
