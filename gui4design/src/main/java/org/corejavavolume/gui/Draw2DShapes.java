package org.corejavavolume.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.File;

/**
 * 根据例子，画椭圆，举行，线段，园
 */
public class Draw2DShapes {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            DrawFrame frame = new DrawFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Draw shapes.");
            frame.setVisible(true);
        });
    }
}

class DrawFrame extends JFrame {
    public DrawFrame(){
//        add(new DrawComponent());
//        add(new TitlePanel());
        add(new ImageComponent());
        pack();
    }
}

class DrawComponent extends JComponent {
    private final int DEFAULT_WIDTH;
    private final int DEFAULT_HEIGHT;

    public DrawComponent(){
        setSize(600, 600);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        DEFAULT_WIDTH = dimension.width;
        DEFAULT_HEIGHT = dimension.height;
    }

    public void paintComponent(Graphics g){
        Graphics2D graphics2D = (Graphics2D) g;
        //draw a rectangle
        float leftX = 100;
        float topY = 100;
        float width = 200;
        float height = 150;

        Rectangle2D rect = new Rectangle2D.Float(leftX, topY, width, height);
        graphics2D.draw(rect);

        // draw enclosed ellipse
        Ellipse2D ellipse = new Ellipse2D.Float();
        ellipse.setFrame(rect);
        graphics2D.draw(ellipse);

        //draw a diagonal line
        Line2D line = new Line2D.Float(leftX, topY, leftX+width, topY+height);
        graphics2D.draw(line);

        //another line
        Line2D oLine = new Line2D.Float(leftX, topY + height, leftX+width, topY);
        graphics2D.draw(oLine);

        //draw a circle with the same center
        double centerX = rect.getCenterX();
        double centerY = rect.getCenterY();
        System.out.println(centerX+" ---- "+centerY);
        double radius = 150;

        Ellipse2D circle = new Ellipse2D.Double();
        circle.setFrameFromCenter(centerX, centerY, centerX+radius, centerY+radius);
        graphics2D.draw(circle);

        //draw image

        String dir = System.getProperty("user.dir") + "\\gui4design\\src\\main\\resources\\environment.jpg";
        dir.replace("/", "\\");
        System.out.println(dir);
        File file = new File(dir);
        if(file.exists()){
            System.out.println("找到了图片了！");
        } else {
            System.out.println("未找到文件");
        }
        Image image = new ImageIcon(dir).getImage();
        graphics2D.drawImage(image, 200, 600, null);

    }

    public Dimension getPreferredSize(){
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}

class ImageComponent extends JComponent {
    private static final int DEFAULT_WIDTH = 900;
    private static final int DEFAULT_HEIGHT = 700;
    private Image image;

    public ImageComponent(){
        String dir = System.getProperty("user.dir") + "\\gui4design\\src\\main\\resources\\icon.gif";
        image = new ImageIcon(dir).getImage();
    }

    public void paintComponent(Graphics graphics){
        if(image == null) return;
        int imgWidth = image.getWidth(this);
        int imgHeight = image.getHeight(this);

        graphics.drawImage(image, 0, 0, null);

        //上边是画一个图，下边循环是将图片铺满整个屏幕
        for(int i=0; i * imgWidth <= getWidth(); i++){
            for (int j=0; j* imgHeight <= getHeight(); j++){
                if(i+j > 0){
                    graphics.copyArea(0, 0, imgWidth, imgHeight, i * imgWidth, j * imgHeight);
                    try {
                        Thread.sleep(50 * 1L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public Dimension getPreferredSize(){
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}

class TitlePanel extends JPanel{
    private final int DEFAULT_WIDTH = 50;
    private final int DEFAULT_HEIGHT = 200;
    public void paintComponent(Graphics g){
        setSize(200, 50);
        String dir = System.getProperty("user.dir");
        g.drawString(dir, 10, 20);
    }
    public Dimension getPreferredSize(){
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
