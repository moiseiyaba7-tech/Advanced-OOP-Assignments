import javax.swing.*;
import java.awt.*;

public class WorkingWithTabbedPanes {
    JFrame mainFrame;
    JTabbedPane tabbedPane;

    public WorkingWithTabbedPanes() {
        this.createJFrame();
    }

    public void createJFrame() {
        mainFrame = new JFrame("Working with Tabbed Panes");
        
        // I set the window to be maximized by default
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // I initialized the JTabbedPane to hold the different sections
        tabbedPane = new JTabbedPane();

        // I added five distinct tabs, each with different UI components
        tabbedPane.addTab("Home", createHomePanel());
        tabbedPane.addTab("Profile", createProfilePanel());
        tabbedPane.addTab("Settings", createSettingsPanel());
        tabbedPane.addTab("Notifications", createNotificationPanel());
        tabbedPane.addTab("Help", createHelpPanel());

        mainFrame.add(tabbedPane);
        mainFrame.setVisible(true);
    }

    private JPanel createHomePanel() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Welcome to the Dashboard"));
        return panel;
    }

    private JPanel createProfilePanel() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Enter Name:"));
        panel.add(new JTextField(20));
        return panel;
    }

    private JPanel createSettingsPanel() {
        JPanel panel = new JPanel();
        panel.add(new JCheckBox("Enable Dark Mode"));
        return panel;
    }

    private JPanel createNotificationPanel() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("No new messages."));
        return panel;
    }

    private JPanel createHelpPanel() {
        JPanel panel = new JPanel();
        panel.add(new JButton("Contact Support"));
        return panel;
    }
}