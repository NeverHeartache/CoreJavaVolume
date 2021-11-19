package org.application.combat;

import org.application.combat.layout.TopLayout;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 项目实战启动类
 * @author dell
 * @version 1.0.1
 */
public class ApplicationBoot {
    /**
     * 框架休眠时间
     */
    private long sleepPeriod = 1000 * 60 * 50;

    /**
     * 框架展示显示时间
     */
    private long showDelay = 1000 * 60 * 10;

    /**
     * 展示之后，窗口隐藏；
     */
    private long hidePeriod = 1000 * 5;



    public static void main(String[] args) {
        ApplicationBoot boot = new ApplicationBoot();
        EventQueue.invokeLater(() -> {
            JFrame homeFrame = new TopLayout();
            homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            homeFrame.setVisible(true);
            try {
                Thread.sleep(5000L);
                boot.sheduleFrame(homeFrame);
            } catch (InterruptedException e) {
                homeFrame.setVisible(true);
                e.printStackTrace();
            }
        });
    }


    private void sheduleFrame(JFrame jFrame) {
        Timer frameVisibleTimer = new java.util.Timer("FrameVisibleTimer");
        TimerTask frameTimerTask = new TimerTask() {
            @Override
            public void run() {
                try {
                    jFrame.setVisible(true);
                    Thread.sleep(hidePeriod);//展示一段时间
                    jFrame.setVisible(false);
                    Thread.sleep(showDelay);
                } catch (InterruptedException e) {
                    jFrame.setVisible(true);
                    e.printStackTrace();
                }
            }
        };
        frameVisibleTimer.scheduleAtFixedRate(frameTimerTask, new Date(), sleepPeriod);
    }

}
