package week8;

import javax.swing.*;
import java.awt.*;

public class StudentRegistration {
    public static void main(String[] args) {
        JFrame f = new JFrame("Student Registration");
        f.setSize(400, 350);
        f.setLayout(new GridLayout(6, 2));

        JLabel l1 = new JLabel("Student Name:");
        JLabel l2 = new JLabel("Register Number:");
        JLabel l3 = new JLabel("Gender:");
        JLabel l4 = new JLabel("Department:");

        JTextField name = new JTextField();
        JTextField reg = new JTextField();

        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        JPanel gender = new JPanel();
        gender.add(male);
        gender.add(female);

        JComboBox<String> dept = new JComboBox<>(
            new String[]{"CSE", "ECE", "EEE", "MECH"}
        );

        JButton submit = new JButton("Submit");

        f.add(l1);
        f.add(name);
        f.add(l2);
        f.add(reg);
        f.add(l3);
        f.add(gender);
        f.add(l4);
        f.add(dept);
        f.add(new JLabel());
        f.add(submit);

        submit.addActionListener(e -> {
            String g = male.isSelected() ? "Male" : "Female";

            JOptionPane.showMessageDialog(f,
                "Name: " + name.getText() +
                "\nRegister No: " + reg.getText() +
                "\nGender: " + g +
                "\nDepartment: " + dept.getSelectedItem());
        });

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}