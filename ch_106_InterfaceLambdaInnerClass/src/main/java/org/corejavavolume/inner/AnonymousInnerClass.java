package org.corejavavolume.inner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;

/**
 * 匿名内部类的测试代码
 * @author lenovo
 * @version 1.0.1
 */
public class AnonymousInnerClass {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            TalkingClock4Anonymous talkingClock4Anonymous = new TalkingClock4Anonymous();
            talkingClock4Anonymous.start(1000, true);
        });
        JOptionPane.showMessageDialog(null,"Quit Program?");
        System.exit(0);

    }
}

class TalkingClock4Anonymous{
    public void start(int interval, boolean beep){
        //匿名内部类
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("TalkingClock4Anonymous," + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                if (beep) {
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        };
        Timer timer = new Timer(interval, listener);
        timer.start();
    }
}
