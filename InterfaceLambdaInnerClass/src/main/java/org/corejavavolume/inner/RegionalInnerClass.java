package org.corejavavolume.inner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class RegionalInnerClass {
    public static void main( String[] args) {
        System.out.println(args[0]);//想要显示该参数，得在Run/Debugge 里的 edit configuration 里头配置
        //args 1，2
        EventQueue.invokeLater(()->{
            if ( "yes".equals(args[0])) {
                TalkingClock4Regional tc4r = new TalkingClock4Regional(1000, true);
                tc4r.start();
            } else {
                TalkingClock4RegionalWithoutField tc4r = new TalkingClock4RegionalWithoutField();
                tc4r.start(1000, true);
            }
        });
        JOptionPane.showMessageDialog(null, "Quit Program?");
        System.exit(0);
    }
}

class TalkingClock4Regional {
    private int interval;
    private boolean beep;
    public TalkingClock4Regional(int interval, boolean beep){
        this.interval = interval;
        this.beep = beep;
    }

    public void start(){
        class TimePrinter4Regional implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("TalkingClock4Regional," + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                if (beep){
                    Toolkit.getDefaultToolkit().beep();
                    ///如果这里用的是方法的传参，那么这个方法的参数在方法结束以后就不存在了，而这里的局部内部类竟然还能用，所以说明，内部类有保存了唯一副本变量
                }
            }
        }
//        可以正常使用lambda表达式
//        ActionListener actionListener = (e)->{
//            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//            if (beep){
//                Toolkit.getDefaultToolkit().beep();
//            }
//        };
        ActionListener actionListener = new TimePrinter4Regional();
        Timer timer = new Timer(interval, actionListener);
        timer.start();
    }
}

class TalkingClock4RegionalWithoutField {

    public void start(int interval, boolean beep){
        class TimePrinter4Regional implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("TalkingClock4RegionalWithoutField," + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                if (beep){
                    Toolkit.getDefaultToolkit().beep();
                    ///如果这里用的是方法的传参，那么这个方法的参数在方法结束以后就不存在了，而这里的局部内部类竟然还能用，所以说明，内部类有保存了唯一副本变量
                }
            }
        }
//        可以正常使用lambda表达式
//        ActionListener actionListener = (e)->{
//            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//            if (beep){
//                Toolkit.getDefaultToolkit().beep();
//            }
//        };
        ActionListener actionListener = new TimePrinter4Regional();
        Timer timer = new Timer(interval, actionListener);
        timer.start();
    }
}
