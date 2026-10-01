package week8;

import javax.swing.*;
import java.awt.*;

public class CourseManagement {
    public static void main(String[] args) {
        JFrame f = new JFrame("Student Course Management");
        f.setSize(600, 400);
        f.setLayout(new BorderLayout());

        String[] courses = {
            "Java",
            "Data Structures",
            "Operating Systems",
            "Computer Networks"
        };

        JList<String> list = new JList<>(courses);

        String[] columns = {"Student Name", "Course", "Status"};

        Object[][] data = {
            {"Anvi", "Java", "Enrolled"},
            {"Rahul", "DSA", "Not Enrolled"},
            {"Priya", "OS", "Enrolled"}
        };

        JTable table = new JTable(data, columns);

        JButton add = new JButton("Add");
        JButton remove = new JButton("Remove");

        JPanel buttons = new JPanel();
        buttons.add(add);
        buttons.add(remove);

        add.addActionListener(e -> {
            JOptionPane.showMessageDialog(f,
                "Course Added: " + list.getSelectedValue());
        });

        remove.addActionListener(e -> {
            JOptionPane.showMessageDialog(f,
                "Course Removed: " + list.getSelectedValue());
        });

        f.add(new JScrollPane(list), BorderLayout.WEST);
        f.add(new JScrollPane(table), BorderLayout.CENTER);
        f.add(buttons, BorderLayout.SOUTH);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
