package org.corejavavolume.gui;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Paths;

public class SizedFrameTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            SizedFrame sizedFrame = new SizedFrame();
            sizedFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            sizedFrame.setTitle("Home");
            sizedFrame.setVisible(true);
        });
    }
}

class SizedFrame extends JFrame{
    public SizedFrame(){
        //get screen size
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        int screenWidth = dimension.width;
        int screenHeight = dimension.height;

        //set width and height and let platform pick screen location
        setSize(screenWidth, screenHeight);
        setLocationByPlatform(true);

        //set frame icon
        Image img = new ImageIcon("ico.jpg").getImage();
        setIconImage(img);
    }
}
