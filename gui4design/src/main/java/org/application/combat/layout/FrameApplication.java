package org.application.combat.layout;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class FrameApplication {

    /**
     * 框架休眠时间
     */
    private final long SLEEP_DELAY = 1000 * 60 * 50;

    /**
     * 框架展示显示时间
     */
    private final long SHOW_DELAY = 1000 * 60 * 10;

    /**
     * 展示之后，窗口隐藏；
     */
    private final long HIDE_DELAY = 1000 * 5;

    /**
     * 全局框架
     */
    private TopLayout jFrame;

    /**
     * 系统工具箱
     */
    private Toolkit toolkit;

    /**
     * 系统托盘
     */
    private SystemTray systemTray;

    /**
     * 构造函数，初始化
     */
    public FrameApplication() {
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
                    Thread.sleep(HIDE_DELAY);//展示一段时间，5S
                    jFrame.setVisible(false);
                    // 睡10分钟
                    Thread.sleep(SHOW_DELAY);
                    //展示一次
                    jFrame.setVisible(true);
                    Thread.sleep(HIDE_DELAY);//展示一段时间，5S
                    jFrame.setVisible(false);
                } catch (InterruptedException e) {
                    jFrame.setVisible(true);
                    e.printStackTrace();
                }
            }
        };
        frameVisibleTimer.scheduleAtFixedRate(frameTimerTask, new Date(), SLEEP_DELAY);
    }
}
