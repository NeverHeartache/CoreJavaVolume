package org.corejavavolume.inner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * https://v.qq.com/x/page/f3015penhto.html
 * 国医邓铁涛老爷子视频
 *
 * 类B引用类A的内部类，进行测试
 */
public class UseOtherInnerClass {
    public static void main(String[] args) {
        EventQueue.invokeLater(()-> {
            ShowTime showTime = new ShowTime();
            showTime.setTitle("小时间");
            showTime.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            showTime.setVisible(true);
        });
    }
}

class ShowTime extends JFrame {

    public ShowTime() {
        setLocationByPlatform(true);
        TimePanel timePanel = new TimePanel();
        add(timePanel);
        pack();
    }

}

class TimePanel extends JPanel{
    public static ActionListener timeSecond;
    private static Timer timer;
    private Timer printTimer;
    private SimpleDateFormat sdf;
    public TimePanel(){
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //add JComponent
        String current = "";
        current = sdf.format(new Date());
        JLabel timeLabel = new JLabel(current);
        add(timeLabel);
        JButton startBtn = new JButton("start");
        JButton stopBtn = new JButton("stop");

        timeSecond = (e)->{
            timeLabel.setText(sdf.format(new Date()));
        };
        timer = new Timer(1000, timeSecond);

        add(startBtn);
        add(stopBtn);

        //org.corejavavolume.inner.InnerClassTest中的TalkingClock.TimePrinter内部类（事件监听类）
        //TODO 使用了同包的类的内部类，并添加了事件监听器类。
        TalkingClock.TimePrinter timePrinter = new TalkingClock(1000, false).new TimePrinter();
        printTimer = new Timer(1000, timePrinter);
        startBtn.addActionListener((e)->{
            timer.start();
            printTimer.start();
        });

        stopBtn.addActionListener((e)->{
            timer.stop();
            printTimer.stop();
        });
    }

    public void start(){
        timer.start();
    }

    public void stop(){
        timer.stop();
    }

}



