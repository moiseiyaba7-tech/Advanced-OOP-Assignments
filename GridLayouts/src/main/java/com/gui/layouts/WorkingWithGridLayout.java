package com.gui.layouts;

import javax.swing.*;
import java.awt.*;

public class WorkingWithGridLayout {
    JFrame frame;

    public WorkingWithGridLayout() {
        frame = new JFrame("Grid Layout Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(3, 1));

        JPanel p1 = new JPanel(); p1.setBackground(Color.BLUE);
        JPanel p2 = new JPanel(); p2.setBackground(Color.GREEN);
        JPanel p3 = new JPanel(); p3.setBackground(Color.WHITE);

        frame.add(p1);
        frame.add(p2);
        frame.add(p3);
        frame.setVisible(true);
    }
}