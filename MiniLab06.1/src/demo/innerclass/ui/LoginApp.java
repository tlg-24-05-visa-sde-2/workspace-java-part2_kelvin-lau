/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package demo.innerclass.ui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginApp extends JFrame {
    private final JLabel nameLabel = new JLabel("Username: ");
    private final JLabel passwordLabel = new JLabel("Password: ");
    private final JTextField nameField = new JTextField(12);
    private final JTextField passwordField = new JPasswordField(12);
    private final JButton loginButton = new JButton("OK");
    private final JLabel messageLabel = new JLabel();

    public LoginApp() {
        super("Please Log In");
        buildUI();
        setFrameOptions();

        // NOTE: pass references to my privates that the listener needs to do its job
        loginButton.addActionListener(new InnerListener());
    }

    private void buildUI() {
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(3, 2));
        pane.add(nameLabel);
        pane.add(nameField);
        pane.add(passwordLabel);
        pane.add(passwordField);
        pane.add(loginButton);
        pane.add(messageLabel);
    }

    private void setFrameOptions() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
    }


    public static void main(String[] args) {
        new LoginApp().setVisible(true);
    }

    // NAMED, MEMBER-LEVEL INNER CLASSES

    private class InnerListener implements ActionListener {
        /**
         * The heart of an ActionListener - this gets called when the event is fired.
         * Need to authenticate the user and display appropriate message on the UI.
         */
        @Override
        public void actionPerformed(ActionEvent evt) {
            if ("derek".equals(nameField.getText()) && "smalls".equals(passwordField.getText())) {
                messageLabel.setText("Login successful!");
            }
            else {
                messageLabel.setText("Sorry, try again");
            }
            nameField.setText("");
            passwordField.setText("");
        }
    }
}