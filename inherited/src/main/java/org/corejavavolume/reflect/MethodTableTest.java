package org.corejavavolume.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Method class, invoke method.
 * @author lenovo
 * @version 1.0.0
 */
public class MethodTableTest {
    public static void main(String[] args) throws Exception {
        Method square = MethodTableTest.class.getMethod("square", double.class);
        Method sqrt = Math.class.getMethod("sqrt", double.class);

        //print tables of x,y value
        printTable(1, 10, 10, square);
        printTable(1, 10, 10, sqrt);
    }

    public static double square (double x) {
        return x * x;
    }

    public static void printTable(double from, double to, int n, Method f) {
        // print out the method as table header
        System.out.println(f);
        double dx = ( to - from ) / ( n - 1);
        for (double x = from; x <= to; x += dx) {
            try {
                double y = (Double) f.invoke(null, x);
                System.out.printf("%10.4f | %10.4f%n", x, y);

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
/*
public static double org.corejavavolume.reflect.MethodTableTest.square(double)
    1.0000 |     1.0000
    2.0000 |     4.0000
    3.0000 |     9.0000
    4.0000 |    16.0000
    5.0000 |    25.0000
    6.0000 |    36.0000
    7.0000 |    49.0000
    8.0000 |    64.0000
    9.0000 |    81.0000
   10.0000 |   100.0000
public static double java.lang.Math.sqrt(double)
    1.0000 |     1.0000
    2.0000 |     1.4142
    3.0000 |     1.7321
    4.0000 |     2.0000
    5.0000 |     2.2361
    6.0000 |     2.4495
    7.0000 |     2.6458
    8.0000 |     2.8284
    9.0000 |     3.0000
   10.0000 |     3.1623
 */