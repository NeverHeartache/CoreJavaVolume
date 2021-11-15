package org.application.combat;

import org.application.combat.layout.TopLayout;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * 项目实战启动类
 * @author dell
 * @version 1.0.1
 */
public class ApplicationBoot {
    public static void main(String[] args) {
//        for (int i = 0; i < 20; i++) {
//            Random random = new Random();
//            System.out.println(random.nextInt(20));
//        }
        EventQueue.invokeLater(() -> {
            JFrame homeFrame = new TopLayout();
            homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            homeFrame.setVisible(true);
        });
    }
}
