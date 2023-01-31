package org.princeton.basic;

import org.junit.Test;

import java.math.BigDecimal;

public class BigDecimalTest {

    @Test
    public static void main(String[] args) {
        int middle = 7 / 2; //  向下取整
        System.out.println(middle);
        int integral = 3;
        BigDecimal intgegralBig = new BigDecimal(integral);
        BigDecimal unitBig = new BigDecimal(1000);

        String integralStr = (intgegralBig.divide(unitBig)).toString();
        System.out.println(integralStr);
    }
}
