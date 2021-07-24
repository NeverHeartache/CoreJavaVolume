package org.corejavavolume.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * 根据例子，画椭圆，举行，线段，园
 */
public class Draw2D {
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
        add(new DrawComponent());
        pack();
    }
}

class DrawComponent extends JComponent {
    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 400;

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

        //draw a circle with the same center
        double centerX = rect.getCenterX();
        double centerY = rect.getCenterY();
        double radius = 150;

        Ellipse2D circle = new Ellipse2D.Double();
        circle.setFrameFromCenter(centerX, centerY, centerX+radius, centerY+radius);
        graphics2D.draw(circle);

    }

    public Dimension getPreferredSize(){
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
