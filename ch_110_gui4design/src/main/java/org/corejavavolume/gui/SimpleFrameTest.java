package org.corejavavolume.gui;
import java.awt.*;
import javax.swing.*;

public class SimpleFrameTest  {
    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            SimpleFrame frame = new SimpleFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            System.out.println(frame.getTitle());
//            frame.setLocationByPlatform(true);
            frame.setVisible(true);
            try{
                Thread.sleep(2000);
                frame.setVisible(false);
//                frame.setLocationByPlatform(true);
                frame.setVisible(true);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        });
    }
}

class SimpleFrame extends JFrame {
    private static final int X_POSITION = 500;
    private static final int Y_POSITION = 100;
    public SimpleFrame(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        int screenWidth = dimension.width;
        int screenHeight = dimension.height;
        setSize(screenWidth, screenHeight);
        setTitle("示例框架");
//        setLocation(X_POSITION, Y_POSITION);
    }
}

//方法调用有毛病啊！
