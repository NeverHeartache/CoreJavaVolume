package org.corejavavolume.inner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegionalInnerClass {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            TalkingClock4Regional tc4r = new TalkingClock4Regional(1000, true);
            tc4r.start();
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
                System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                if (beep){
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        }
        ActionListener actionListener = (e)->{
            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            if (beep){
                Toolkit.getDefaultToolkit().beep();
            }
        };
        Timer timer = new Timer(interval, actionListener);
        timer.start();
    }
}
