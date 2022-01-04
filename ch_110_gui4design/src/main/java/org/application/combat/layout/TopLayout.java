package org.application.combat.layout;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.Timer;


public class TopLayout extends JFrame {
    private static JMenuBar jMenuBar;
    private static SimpleDateFormat sdf;
    private static Timer realTimeTimer;
    private static TimerTask realTimeTimerTask;
    static List<String> filePathList = new ArrayList<>();

    public TopLayout(String title, Dimension dimension) {
        setTitle(title);
        setPreferredSize(dimension);
        setLocationByPlatform(true);
        initFileList();
//        addImagePane();
    }

    public void initFileList() {
        String topLayoutPath = TopLayout.class.getResource("/static/img/").getPath();
        System.out.println(topLayoutPath);
        File topFile = new File(topLayoutPath);
        if (topFile.isDirectory()) {
            File[] files = topFile.listFiles();
            for (File e:files) {
                if (e.isDirectory()) continue;
                filePathList.add(e.getPath() + e.getName());
            }
        }
    }

    public void initTimer(){
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        realTimeTimer = new Timer("second", false);
    }

    public JMenuBar addMenu() {
        jMenuBar = new JMenuBar();
        setJMenuBar(jMenuBar);
        jMenuBar.setSize(getSize().width, 20);
        //
        JMenu fileMenu = new JMenu("File");
        jMenuBar.add(fileMenu);
        fileMenu.addSeparator();
        //
        JMenuItem pastItem = new JMenuItem("Past");
        fileMenu.add(pastItem);

        return jMenuBar;
    }

    public void addImagePane() {
        add(new RandomImgComponent());
        pack();
    }

    public void addTimeLabelOfCenter() {
        JPanel botmJPanel = new JPanel();
        add(botmJPanel);
        pack();
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
            Font timeLabelFont = new Font("微软雅黑 Light", Font.BOLD, 28);
            graphics2D.setFont(timeLabelFont);
            graphics2D.drawString(getText(), 100, 50);
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

class RandomImgComponent extends JComponent {
    private static final int DEFAULT_WIDTH = 900;
    private static final int DEFAULT_HEIGHT = 700;
    private Image image;
    private Timer imgChangeTimer;
    private TimerTask imgTimerTask;

    public RandomImgComponent() {
        image = new ImageIcon(TopLayout.filePathList.get(0)).getImage();
//        imgChangeTimer = new Timer("imgChange");
//        imgTimerTask = new TimerTask() {
//            @Override
//            public void run() {
//                Random random = new Random();
//                int ind = random.nextInt(TopLayout.filePathList.size());
//                if (ind == TopLayout.filePathList.size()) ind = ind - 1;
//                image = new ImageIcon(TopLayout.filePathList.get(ind)).getImage();
//            }
//        };
//        imgChangeTimer.scheduleAtFixedRate(imgTimerTask, new Date(), 1000);
    }

    public void paintComponent(Graphics graphics){
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.drawImage(image, 0, 0, null);
     }

    public Dimension getPreferredSize(){
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
