package org.corejavavolume.awt;

import org.corejavavolume.annotation.ActionListenerFor;
import org.corejavavolume.annotation.ActionListenerInstaller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyButtonAction {
    public static void main(String[] args) {
        EventQueue.invokeLater(()-> {
            JFrame btnFrame;
            if (args[0].equals("default")){
                btnFrame = new ButtonsFrame();
            } else {
                btnFrame = new ButtonsFrameForAnnotation();
            }
            btnFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            btnFrame.setVisible(true);
        });
    }
}

class ButtonsFrame extends JFrame{
    private JPanel buttonPanel;

    public ButtonsFrame(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        int defaultWidth = dimension.width / 2;
        int defaultHeight = dimension.height / 2;
        setSize(defaultWidth, defaultHeight);
        setLocationByPlatform(true);

        //三个button按钮
        JButton yellowBtn = new JButton("Yellow");
        JButton blueBtn = new JButton("Blue");
        JButton redBtn = new JButton("Red");

        buttonPanel = new JPanel();

        buttonPanel.add(yellowBtn);
        buttonPanel.add(blueBtn);
        buttonPanel.add(redBtn);
//        buttonPanel.setBorder();

        add(buttonPanel);

        //create button actions
        ColorAction yellowAct = new ColorAction(Color.YELLOW);
        ColorAction blueAct = new ColorAction(Color.blue);
        ColorAction redAct = new ColorAction(Color.RED);

        yellowBtn.addActionListener(yellowAct);
        blueBtn.addActionListener(blueAct);
        redBtn.addActionListener(redAct);

    }

    private class ColorAction implements ActionListener{
        private Color backgroundColor;

        private ColorAction(Color color){
            backgroundColor = color;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            buttonPanel.setBackground(backgroundColor);
        }
    }
}

class ButtonsFrameForAnnotation extends JFrame{
    private JButton yellowBtn;
    private JButton blueBtn;
    private JButton redBtn;
    private JPanel buttonPanel;

    public ButtonsFrameForAnnotation(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        int defaultWidth = dimension.width / 2;
        int defaultHeight = dimension.height / 2;
        setSize(defaultWidth, defaultHeight);
        setLocationByPlatform(true);

        //三个button按钮
        yellowBtn = new JButton("Yellow");
        blueBtn = new JButton("Blue");
        redBtn = new JButton("Red");
        buttonPanel = new JPanel();

        buttonPanel.add(yellowBtn);
        buttonPanel.add(blueBtn);
        buttonPanel.add(redBtn);

        add(buttonPanel);

        ActionListenerInstaller.processAnnotations(this);
    }

    @ActionListenerFor(source = "yellowBtn")
    public void setYellowBg(){
        buttonPanel.setBackground(Color.YELLOW);
    }

    @ActionListenerFor(source = "blueBtn")
    public void setBlueBg(){
        buttonPanel.setBackground(Color.BLUE);
    }

    @ActionListenerFor(source = "redBtn")
    public void setRedBg(){
        buttonPanel.setBackground(Color.RED);
    }
}


