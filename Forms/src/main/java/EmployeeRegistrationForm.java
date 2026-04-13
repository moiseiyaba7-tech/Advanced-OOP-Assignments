import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class EmployeeRegistrationForm {
    JFrame mainFrame;
    JTextField nameField, emailField;
    JPasswordField passwordField;
    JComboBox<String> deptBox;
    JTree orgTree;

    public EmployeeRegistrationForm() {
        createJFrame();
    }

    public void createJFrame() {
        mainFrame = new JFrame("Employee Registration System");
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        
        formPanel.add(new JLabel("Full Name:"));
        nameField = new JTextField();
        formPanel.add(nameField);

        formPanel.add(new JLabel("Email Address:"));
        emailField = new JTextField();
        formPanel.add(emailField);

        formPanel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        formPanel.add(passwordField);

        formPanel.add(new JLabel("Department:"));
        String[] depts = {"IT", "Finance", "HR", "Marketing"};
        deptBox = new JComboBox<>(depts);
        formPanel.add(deptBox);

        JButton submitBtn = new JButton("Submit");
        submitBtn.addActionListener(e -> handleSubmit());
        formPanel.add(submitBtn);

        JButton clearBtn = new JButton("Clear");
        clearBtn.addActionListener(e -> clearFields());
        formPanel.add(clearBtn);

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Company");
        DefaultMutableTreeNode deptNode = new DefaultMutableTreeNode("Departments");
        deptNode.add(new DefaultMutableTreeNode("Tech Team"));
        deptNode.add(new DefaultMutableTreeNode("Admin Team"));
        root.add(deptNode);
        orgTree = new JTree(root);

        mainFrame.add(formPanel, BorderLayout.WEST);
        mainFrame.add(new JScrollPane(orgTree), BorderLayout.CENTER);
        
        mainFrame.setVisible(true);
    }

    private void handleSubmit() {
        String name = nameField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());

        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(mainFrame, "Error: All fields must be filled!");
        } else {
            String summary = "Registration Successful!\n\n" +
                             "Name: " + name + "\n" +
                             "Email: " + email + "\n" +
                             "Dept: " + deptBox.getSelectedItem() + "\n" +
                             "Password: ******";
            JOptionPane.showMessageDialog(mainFrame, summary);
        }
    }

    private void clearFields() {
        nameField.setText("");
        emailField.setText("");
        passwordField.setText("");
        deptBox.setSelectedIndex(0);
    }
}