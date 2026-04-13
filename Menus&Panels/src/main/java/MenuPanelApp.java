import javax.swing.*;
import java.awt.*;

public class MenuPanelApp {
    JFrame mainFrame;
    JPanel contentPanel;
    CardLayout cardLayout;

    public MenuPanelApp() {
        createJFrame();
    }

    public void createJFrame() {
        mainFrame = new JFrame("Working with Menus & Panels");
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // I used CardLayout to easily switch between different panels
        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);

        // Adding different sections to the content panel
        contentPanel.add(createHomePanel(), "Home");
        contentPanel.add(createAboutPanel(), "About");

        // Creating the Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu navigationMenu = new JMenu("Navigation");

        JMenuItem homeItem = new JMenuItem("Go to Home");
        homeItem.addActionListener(e -> cardLayout.show(contentPanel, "Home"));

        JMenuItem aboutItem = new JMenuItem("Go to About");
        aboutItem.addActionListener(e -> cardLayout.show(contentPanel, "About"));

        navigationMenu.add(homeItem);
        navigationMenu.add(aboutItem);
        menuBar.add(navigationMenu);

        mainFrame.setJMenuBar(menuBar);
        mainFrame.add(contentPanel);
        mainFrame.setVisible(true);
    }

    private JPanel createHomePanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.add(new JLabel("This is the Home Section"));
        return panel;
    }

    private JPanel createAboutPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.add(new JLabel("This is the About Section - Version 1.0"));
        return panel;
    }
}