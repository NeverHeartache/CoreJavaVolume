package org.application.combat.layout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
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
    public FrameApplication() throws IOException {
        toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame = new TopLayout("Timeline", dimension);
        initTray(jFrame);
    }

    /**
     * 初始化框架
     */
    public void initFrame() {
        EventQueue.invokeLater(() -> {
            jFrame.setVisible(true);
            jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            jFrame.initTimer();
            jFrame.addTimeLabelOfCenter();
            //  所有内容初始化完成之后，再进行框架定时任务；
            sheduleFrame(jFrame);
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

    private void initTray(JFrame jFrame) throws IOException {
        if(SystemTray.isSupported()){
            SystemTray systemTray = SystemTray.getSystemTray();//创建托盘
            PopupMenu popupMenu = new PopupMenu();

            MenuItem openItem = new MenuItem("open");
            MenuItem exitItem = new MenuItem("exit");
            openItem.addActionListener(e -> {
                if (!jFrame.isShowing()) {
                    jFrame.setVisible(true);
                }
            });
            exitItem.addActionListener(e -> {
                System.exit(0);
            });
            popupMenu.add(openItem);
            popupMenu.add(exitItem);
            TrayIcon trayIcon = new TrayIcon(createImage("/ico.jpg", ""), "Timeline！Let's have a rest!",popupMenu);
            // 托盘图标自适应尺寸
            trayIcon.setImageAutoSize(true);
            trayIcon.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("托盘图标被右键点击");
                }
            });
            trayIcon.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    switch (e.getButton()) {
                        case MouseEvent.BUTTON1: {
                            System.out.println("托盘图标被鼠标左键被点击");
                            break;
                        }
                        case MouseEvent.BUTTON2: {
                            System.out.println("托盘图标被鼠标中键被点击");
                            break;
                        }
                        case MouseEvent.BUTTON3: {
                            System.out.println("托盘图标被鼠标右键被点击");
                            break;
                        }
                        default: {
                            break;
                        }
                    }
                }
            });
            // 添加托盘图标到系统托盘
            try {
                systemTray.add(trayIcon);
            } catch (AWTException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("当前系统不支持系统托盘");
        }
    }

    protected static Image createImage(String path, String description) {
        URL imageURL = FrameApplication.class.getResource(path);

        if (imageURL == null) {
            System.err.println("Resource not found: " + path);
            return null;
        } else {
            return (new ImageIcon(imageURL, description)).getImage();
        }
    }
}
