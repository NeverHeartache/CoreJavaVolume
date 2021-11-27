package org.application.combat.layout;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import org.application.combat.constant.ApplicationConst;

/**
 * 全局应用框架
 *
 */
public class FrameApplication {

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
        toolkit = Toolkit.getDefaultToolkit();
        int width = toolkit.getScreenSize().width;
        int height = toolkit.getScreenSize().height;
        jFrame = new TopLayout("Timeline", width, height);
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
                    Thread.sleep(ApplicationConst.HIDE_DELAY);//展示一段时间，5S
                    jFrame.setVisible(false);
                    // 睡10分钟
                    Thread.sleep(ApplicationConst.SHOW_DELAY);
                    //展示一次
                    jFrame.setVisible(true);
                    Thread.sleep(ApplicationConst.HIDE_DELAY);//展示一段时间，5S
                    jFrame.setVisible(false);
                } catch (InterruptedException e) {
                    jFrame.setVisible(true);
                    e.printStackTrace();
                }
            }
        };
        frameVisibleTimer.scheduleAtFixedRate(frameTimerTask, new Date(), ApplicationConst.SLEEP_DELAY);
    }
}
