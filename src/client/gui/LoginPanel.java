package client.gui;

import javax.swing.*;

public class LoginPanel extends JPanel {

    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton signup = new JButton("Signup");
    JCheckBox showPassword = new JCheckBox("Show Password");

    public LoginPanel() {
        setLocationAndSize();
        addComponentsToPanel();
    }

    public void addComponentsToPanel() {
        add(userLabel);
        add(passwordLabel);
        add(userTextField);
        add(passwordField);
        add(showPassword);
        add(loginButton);
        add(signup);
    }

    public void setLocationAndSize() {
        this.setBounds(0,0,400,400);
        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds(500, 500, 100, 30);
        signup.setBounds(200, 300, 100, 30);
    }

    public void addActionEvent() {
//        loginButton.addActionListener(this);
//        signup.addActionListener(this);
//        showPassword.addActionListener(this);
    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//    }
}
