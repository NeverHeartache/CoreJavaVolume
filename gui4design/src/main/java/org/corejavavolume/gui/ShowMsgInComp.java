package org.corejavavolume.gui;

import javax.swing.*;
import java.awt.*;

/**
 * 程序单10-3 NotHelloWorld.java
 */
public class ShowMsgInComp {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            MsgInFrame msgInFrame = new MsgInFrame();
            msgInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            msgInFrame.setTitle("敢杀我的马");
            msgInFrame.setVisible(true);
        });
    }
}

class MsgInFrame extends JFrame {
    public MsgInFrame() {
//        Toolkit toolkit = Toolkit.getDefaultToolkit();
//        Dimension dimension = toolkit.getScreenSize();
//        int screenWidth = dimension.width;
//        int screenHeight = dimension.height;
//        setTitle("REST");
//        setSize(screenWidth, screenHeight);
//        setLocation(0,0);
        // add some pane
        WordsPane wordsPane = new WordsPane();
        add(wordsPane);
        pack();
    }
}

class WordsPane extends JComponent {
    public static final int MESSAGE_X = 75;
    public static final int MESSAGE_Y = 100;

    public void paintComponent(Graphics graphics){
        String words = "This is a pane.";
        graphics.drawString(words, MESSAGE_X, MESSAGE_Y);
    }
    public Dimension getPreferredSize(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        dimension.setSize(dimension.width /2, dimension.height/2);
        return dimension;
    }
}
