package org.application.combat.layout;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class TopLayout extends JFrame {
    private static JMenuBar jMenuBar;
    private static Dimension sysDimension;
    private static int frameWidth;
    private static int frameHeight;
    private static Toolkit sysToolkit;
    private static SimpleDateFormat sdf;
    private static Timer realTimeTimer;
    private static TimerTask realTimeTimerTask;
    public TopLayout() {
        init();
        setSize(frameWidth, frameHeight);
        setTitle("HomePage");
        setLocationByPlatform(true);
        // Menu
        addMenu(this);
        // text JPanel
        addTimeLabelOfBottom(this);
    }

    private static void init(){
        sysToolkit = Toolkit.getDefaultToolkit();
        sysDimension = sysToolkit.getScreenSize();
        frameHeight = sysDimension.height / 2;
        frameWidth = sysDimension.width / 2;
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        realTimeTimer = new Timer("second", false);

    }

    public static JMenuBar addMenu(JFrame jFrame) {
        jMenuBar = new JMenuBar();
        jFrame.setJMenuBar(jMenuBar);
        jMenuBar.setSize(frameWidth, 20);
        //
        JMenu fileMenu = new JMenu("File");
        jMenuBar.add(fileMenu);
        fileMenu.addSeparator();
        //
        JMenuItem pastItem = new JMenuItem("Past");
        fileMenu.add(pastItem);

        return jMenuBar;
    }

    public static void addTimeLabelOfBottom(JFrame jFrame) {
        JPanel botmJPanel = new JPanel();
        jFrame.add(botmJPanel, BorderLayout.SOUTH);
        JLabel timeLabel = new JLabel();
        botmJPanel.add(timeLabel);
        timeLabel.setText(sdf.format(new Date()));
        realTimeTimerTask = new TimerTask() {
            @Override
            public void run() {
                timeLabel.setText(sdf.format(new Date()));
            }
        };
        realTimeTimer.scheduleAtFixedRate(realTimeTimerTask, new Date(), 1000);
    }
}
