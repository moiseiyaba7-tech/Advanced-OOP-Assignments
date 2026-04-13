import javax.swing.*;
import java.awt.*;


public class WorkingWithBorderLayout {
    JFrame BorderFrame;
    JLabel JLabelOne;
    JPanel JPanelOne;
    JButton Button1;
    JButton Button2;
    JButton Button3;
    JButton SubmitButton;
    JTextArea TextAreaOne;
    JScrollPane ScrollPaneOne;


    public WorkingWithBorderLayout() {
        this.createJFrame();
    }


    public JFrame createJFrame() {
        BorderFrame = new JFrame("BorderLayout Demo");
        BorderFrame.setSize(600, 400);
        BorderFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BorderFrame.add(this.CreateJLabelOne(), BorderLayout.NORTH);
        BorderFrame.add(this.createJPanel(), BorderLayout.WEST);
        BorderFrame.add(this.createJScrollPane(), BorderLayout.CENTER);
        BorderFrame.add(this.createSubmitButton(), BorderLayout.SOUTH);

        BorderFrame.setVisible(true);
        return BorderFrame;
    }

    public JLabel CreateJLabelOne() {
        JLabelOne = new JLabel();
        JLabelOne.setText("Application Title");
        JLabelOne.setHorizontalAlignment(JLabel.CENTER);
        return JLabelOne;
    }

    public JPanel createJPanel() {
        JPanelOne = new JPanel();
        JPanelOne.setLayout(new GridLayout(3,1));
        JPanelOne.setBorder(BorderFactory.createEmptyBorder());


        JPanelOne.add(this.CreateButtOne());
        JPanelOne.add(this.CreateButtonTwo());
        JPanelOne.add(this.CreateButtonThree());
        return JPanelOne;
    }

    public JButton CreateButtOne() {
        Button1 = new JButton();
        Button1.setText("Option 1");
        return Button1;
    }

    public JButton CreateButtonTwo() {
        Button2 = new JButton();
        Button2.setText("Option 2");
        return Button2;
    }

    public JButton CreateButtonThree() {
        Button3 = new JButton();
        Button3.setText("Option 3");
        return Button3;
    }

    public JScrollPane createJScrollPane() {
        TextAreaOne = new JTextArea();
        ScrollPaneOne = new JScrollPane(TextAreaOne);

        return ScrollPaneOne;
    }

    public JButton createSubmitButton() {
        SubmitButton = new JButton();
        SubmitButton.setText("Submit");
        return SubmitButton;
    }
}


