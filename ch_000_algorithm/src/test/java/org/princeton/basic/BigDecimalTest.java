package org.princeton.basic;

import java.math.BigDecimal;

public class BigDecimalTest {
    public static void main(String[] args) {
        int integral = 3;
        BigDecimal intgegralBig = new BigDecimal(integral);
        BigDecimal unitBig = new BigDecimal(1000);

        String integralStr = (intgegralBig.divide(unitBig)).toString();
        System.out.println(integralStr);
    }
}
