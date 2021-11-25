package org.application.combat.layout;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class FrameProxy {

    private JFrame jFrame;

    private Toolkit toolkit;

    private SystemTray systemTray;

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

    public FrameProxy() {
        jFrame = new TopLayout();
        toolkit = Toolkit.getDefaultToolkit();
        if (SystemTray.isSupported()) {
            systemTray = SystemTray.getSystemTray();
        }
    }

    /**
     * 初始化框架
     */
    public void initFrame() {
        EventQueue.invokeLater(() -> {
            jFrame.setVisible(true);
        });
    }


    /**
     * 框架首先展示5秒后，消失50分钟，然后，再弹出之后
     * @param jFrame
     */
    public void sheduleFrame(JFrame jFrame) {
        Timer frameVisibleTimer = new java.util.Timer("FrameVisibleTimer");
        TimerTask frameTimerTask = new TimerTask() {
            @Override
            public void run() {
                try {
                    //展示一次
                    jFrame.setVisible(true);
                    Thread.sleep(hidePeriod);//展示一段时间，5S
                    jFrame.setVisible(false);
                    // 睡10分钟
                    Thread.sleep(showDelay);
                    //展示一次
                    jFrame.setVisible(true);
                    Thread.sleep(hidePeriod);//展示一段时间，5S
                    jFrame.setVisible(false);
                } catch (InterruptedException e) {
                    jFrame.setVisible(true);
                    e.printStackTrace();
                }
            }
        };
        frameVisibleTimer.scheduleAtFixedRate(frameTimerTask, new Date(), sleepPeriod);
    }
}
