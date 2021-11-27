package org.application.combat;

import org.application.combat.layout.FrameApplication;

/**
 * 项目实战启动类
 * @author dell
 * @version 1.0.1
 */
public class ApplicationBoot {

    public static FrameApplication frameApplication;

    public static void main(String[] args) {
        frameApplication = new FrameApplication();
        frameApplication.initFrame();
    }
}
