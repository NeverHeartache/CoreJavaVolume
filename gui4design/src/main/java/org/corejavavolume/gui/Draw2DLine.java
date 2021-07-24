package org.corejavavolume.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

/**
 * 在应用上画一个空白坐标系
 */
public class Draw2DLine {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new CoordinateFrame();
            frame.setTitle("坐标系");
            frame.setVisible(true);
        });
    }
}

class CoordinateFrame extends JFrame {
    public CoordinateFrame(){
        add(new Line2DComponent());
        pack();
    }
}

class Line2DComponent extends JComponent {
    private static final int positionX = 800;
    private static final int positionY = 800;

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        //x-axis line
        double xsx = 100;
        double xex = 500;
        double ysx = 500;
        double yex = 500;
        Line2D xAxis = new Line2D.Double(xsx, xex, ysx, yex);
        g2.draw(xAxis);

        // y-axis line
        double xsy = 100;
        double xey = 100;
        double ysy = 100;
        double yey = 500;
        Line2D yAxis = new Line2D.Double(xsy, xey, ysy, yey);
        g2.draw(yAxis);
    }

    public Dimension getPreferredSize(){
        return new Dimension(positionX, positionY);
    }
}