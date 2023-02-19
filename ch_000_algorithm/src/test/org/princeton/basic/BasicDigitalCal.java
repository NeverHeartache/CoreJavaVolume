package org.princeton.basic;

import java.math.BigInteger;

public class BasicDigitalCal {

    private static final double LOG_TWO = Math.log(2.0);
    public static void main(String[] args) {
        byte a1 = (byte) (-128 - 1);
        System.out.printf("a1的值的二进制表示为：%x\n", a1);
        byte b = (byte) 0b11111111;
        System.out.printf("b的值的二进制表示为：%d\n", b);

        System.out.println(LOG_TWO);

    }
}
