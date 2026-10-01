package week8;

import javax.swing.*;
import java.awt.*;

public class UserLogin {
    public static void main(String[] args) {
        JFrame f = new JFrame("User Login");
        f.setSize(350, 250);
        f.setLayout(new GridLayout(5, 2));

        JLabel l1 = new JLabel("Username:");
        JLabel l2 = new JLabel("Password:");

        JTextField user = new JTextField();
        JPasswordField pass = new JPasswordField();

        JCheckBox remember = new JCheckBox("Remember Me");
        JCheckBox notify = new JCheckBox("Receive Notifications");

        JButton login = new JButton("Login");

        f.add(l1);
        f.add(user);
        f.add(l2);
        f.add(pass);
        f.add(remember);
        f.add(notify);
        f.add(new JLabel());
        f.add(login);

        login.addActionListener(e -> {
            if (user.getText().equals("admin") &&
                new String(pass.getPassword()).equals("1234")) {

                JOptionPane.showMessageDialog(f, "Login Successful");
            } else {
                JOptionPane.showMessageDialog(f, "Invalid Username or Password");
            }
        });

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
