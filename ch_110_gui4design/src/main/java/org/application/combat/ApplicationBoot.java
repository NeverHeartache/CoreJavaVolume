package org.application.combat;

import org.application.combat.layout.FrameApplication;

import java.io.IOException;

/**
 * 项目实战启动类
 * @author dell
 * @version 1.0.1
 */
public class ApplicationBoot {

    public static FrameApplication frameApplication;

    public static void main(String[] args) {
        try {
            frameApplication = new FrameApplication();
        } catch (IOException e) {
            e.printStackTrace();
        }
        frameApplication.initFrame();
    }
}
