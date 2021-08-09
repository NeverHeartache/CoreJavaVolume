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
