package com.gui.layouts;
import javax.swing.*;
import java.awt.*;

public class WorkingWithGridLayout {
    JFrame mainFrame;
    JPanel panelOne;
    JPanel panelTwo;
    JPanel panelThree;

    public WorkingWithGridLayout() {
        this.createJFrame();
    }

    public JFrame createJFrame() {
        mainFrame = new JFrame("Working with Layouts (GridLayouts)");
        
      
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainFrame.setLayout(new GridLayout(1, 3));

        mainFrame.add(this.createPanelOne());
        mainFrame.add(this.createPanelTwo());
        mainFrame.add(this.createPanelThree());

        mainFrame.setVisible(true);
        return mainFrame;
    }

    public JPanel createPanelOne() {
        panelOne = new JPanel();
        panelOne.setBackground(Color.BLUE); 
        return panelOne;
    }

    public JPanel createPanelTwo() {
        panelTwo = new JPanel();
        panelTwo.setBackground(Color.GREEN);
        return panelTwo;
    }

    public JPanel createPanelThree() {
        panelThree = new JPanel();
        panelThree.setBackground(Color.WHITE);
        return panelThree;
    }
}