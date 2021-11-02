package org.application.combat.layout;

import javax.swing.*;
import java.awt.*;

public class TopLayout extends JFrame {
    public TopLayout() {
        Toolkit sysToolkit = Toolkit.getDefaultToolkit();
        Dimension sysDimension = sysToolkit.getScreenSize();
        int height = sysDimension.height;
        int width = sysDimension.width;
        setSize(sysDimension);
        setTitle("HomePage");
        setLocationByPlatform(true);
    }
}
