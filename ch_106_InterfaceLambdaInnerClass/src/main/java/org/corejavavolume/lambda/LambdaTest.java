package org.corejavavolume.lambda;

import javax.swing.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

/**
 * 在排序和定时类上使用lambda表达式来传递代码块
 */
public class LambdaTest {
    public static void main(String[] args) {
        String[] planets = new String[]{"Mercury","Venus","Earth","Mars","Jupiter","Saturn","Uranus","Neptune"};
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted in dictionary order:");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted by length:");
        Arrays.sort(planets, Comparator.comparingInt(String::length));//等价于下边这句
//        Arrays.sort(planets, (first, second) -> first.length() - second.length());
        System.out.println(Arrays.toString(planets));

        Timer t = new Timer(1000, event -> System.out.println("The time is: "+new Date()));
        t.start();

        JOptionPane.showMessageDialog(null,"Quit Program?");
        System.exit(0);
    }
}
