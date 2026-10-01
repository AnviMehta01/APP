package week9;

import javax.swing.*;
import java.awt.*;

class GradeModel {
    String name;
    double m1, m2, m3;

    GradeModel(String name, double m1, double m2, double m3) {
        this.name = name;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
    }

    double total() {
        return m1 + m2 + m3;
    }

    double average() {
        return total() / 3;
    }

    String grade() {
        double a = average();

        if (a >= 90)
            return "A";
        else if (a >= 75)
            return "B";
        else if (a >= 60)
            return "C";
        else if (a >= 50)
            return "D";
        else
            return "F";
    }
}

class GradeView extends JFrame {
    JTextField name = new JTextField();
    JTextField m1 = new JTextField();
    JTextField m2 = new JTextField();
    JTextField m3 = new JTextField();
    JButton calculate = new JButton("Calculate Result");

    GradeView() {
        setTitle("Student Grade Calculator");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Student Name:"));
        add(name);
        add(new JLabel("Subject 1:"));
        add(m1);
        add(new JLabel("Subject 2:"));
        add(m2);
        add(new JLabel("Subject 3:"));
        add(m3);
        add(new JLabel());
        add(calculate);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

class GradeController {
    GradeView view;

    GradeController(GradeView view) {
        this.view = view;

        view.calculate.addActionListener(e -> {
            try {
                GradeModel model = new GradeModel(
                    view.name.getText(),
                    Double.parseDouble(view.m1.getText()),
                    Double.parseDouble(view.m2.getText()),
                    Double.parseDouble(view.m3.getText())
                );

                JOptionPane.showMessageDialog(view,
                    "Name: " + model.name +
                    "\nTotal: " + model.total() +
                    "\nAverage: " + model.average() +
                    "\nGrade: " + model.grade());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, "Enter valid marks");
            }
        });
    }
}

public class StudentGradeCalculator {
    public static void main(String[] args) {
        GradeView view = new GradeView();
        new GradeController(view);
    }
}
