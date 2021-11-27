package org.application.combat.layout;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Timer;


public class TopLayout extends JFrame {
    private static JMenuBar jMenuBar;
    private static SimpleDateFormat sdf;
    private static Timer realTimeTimer;
    private static TimerTask realTimeTimerTask;

    public TopLayout(String title, int frameWidth, int frameHeight) {
        setTitle(title);
        setSize(frameWidth, frameHeight);
        setLocation(0,0);
        initTimer();
    }

    private void initTimer(){
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        realTimeTimer = new Timer("second", false);
    }

    public JMenuBar addMenu(JFrame jFrame) {
        jMenuBar = new JMenuBar();
        jFrame.setJMenuBar(jMenuBar);
        jMenuBar.setSize(jFrame.getSize().width, 20);
        //
        JMenu fileMenu = new JMenu("File");
        jMenuBar.add(fileMenu);
        fileMenu.addSeparator();
        //
        JMenuItem pastItem = new JMenuItem("Past");
        fileMenu.add(pastItem);

        return jMenuBar;
    }

    public void addTimeLabelOfCenter(JFrame jFrame) {
        JPanel botmJPanel = new JPanel();
        jFrame.add(botmJPanel, BorderLayout.SOUTH);

        JLabel timeLabel = new TimeLabel();
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

    public void addBootTimeLable(JFrame jFrame) {

    }

//    public void draw

    class TimeLabel extends JLabel {

        public void paintComponent(Graphics graphics) {
            Graphics2D graphics2D = (Graphics2D) graphics;
            Font timeLabelFont = new Font("微软雅黑 Light", Font.BOLD, 18);
            graphics2D.setFont(timeLabelFont);
            graphics2D.drawString(getText(), 160, 20);
        }

        public Dimension getPreferredSize(){
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension dimension = toolkit.getScreenSize();
            dimension.setSize(dimension.width / 4, 50);
            return dimension;
        }
    }

    /**
     * 随机获取字体
     * @return 字体
     */
    private String getRandomFont(){
        String font = new String();
        String[] fontList = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        Random random = new Random();
        return fontList[random.nextInt(fontList.length)];
    }

    /**
     * 查看本地所有字体
     */
    private void listAllLocalFont(){
        String[] fontList = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        Arrays.stream(fontList).forEach(p -> {
            System.out.println(p);
        });
    }
}
