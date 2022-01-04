package org.corejavavolume.inner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InnerClassTest {
    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock(1000, true);

        /*
        验证一、
         */
        TalkingClock.TimePrinter printer = clock.new TimePrinter();
        System.out.println("内部类的A是：" + printer.getFieldA());
        printer.setFieldA(55);
        TalkingClock.TimePrinter printer2 = clock.new TimePrinter();
        System.out.println("printer2内部类的A是：" + printer.getFieldA());
        System.out.println("两个内部类的引用是否相等呢？结果是：" + printer.equals(printer2));

        /*
        验证二、
         */
        TalkingClock clockb = new TalkingClock(1000, true);
        TalkingClock.TimePrinter printerb = clock.new TimePrinter();
        System.out.println("内部类的A是：" + printer.getFieldA());
        printer.setFieldA(155);
        TalkingClock.TimePrinter printerb2 = clock.new TimePrinter();
        System.out.println("printer2内部类的A是：" + printer.getFieldA());
        System.out.println("两个内部类的引用是否相等呢？验证二，结果是：" + printer.equals(printerb));
        /*
        内部类的A是：10
        printer2内部类的A是：55
        两个内部类的引用是否相等呢？结果是：false，//此时的两个printer,一个是@492，一个是@493
        内部类的A是：55
        printer2内部类的A是：155
        两个内部类的引用是否相等呢？验证二，结果是：false
         */


        clock.start();

        JOptionPane.showMessageDialog(null, "Quit Program?");
        System.exit(0);
    }
}

class TalkingClock {
    private int intervals;
    private boolean beep;
    public TalkingClock(int intervals, boolean beep){
        this.intervals = intervals;
        this.beep = beep;
    }
    public void start(){
        ActionListener listener = new TimePrinter();
        Timer timer = new Timer(intervals, listener);
        timer.start();
    }

    public class TimePrinter implements ActionListener{

        private int fieldA = 10;

        public int getFieldA(){ return fieldA; }

        public void setFieldA(int p){
            this.fieldA = p;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            if(beep){
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                toolkit.beep();
            }
        }
    }
}
