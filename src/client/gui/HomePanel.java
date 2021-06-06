package client.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePanel extends JPanel implements ActionListener {
    JLabel homeHeader = new JLabel("<html><h3>Welcome to the Cinema</h3><br> to access to all functionality please login first</html>");
    JButton loginButton = new JButton("login");
    JButton signupButton = new JButton("signup");
    BoxLayout boxLayout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
    FlowLayout flowLayout = new FlowLayout();
    JPanel buttonsPanel = new JPanel();

    public HomePanel() {
        addComponentsToPanel();
        setLocationAndSize();
        addActionEvent();
        setLayout();
        this.setBackground(new Color(100,100,100));
    }

    public void addComponentsToPanel() {
        buttonsPanel.setLayout(flowLayout);
        buttonsPanel.add(loginButton);
        buttonsPanel.add(signupButton);
        add(homeHeader);
        add(buttonsPanel);
    }

    public void setLocationAndSize() {
        this.setBounds(0,0,700,600);
        homeHeader.setBounds(50, 50, 80, 30);
        loginButton.setBounds(50, 150, 80, 40);
        signupButton.setBounds(150, 250, 80, 40);
    }

    public void addActionEvent() {

    }

    public void setLayout() {
        this.setLayout(boxLayout);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
