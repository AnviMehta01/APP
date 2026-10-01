package week9;

import javax.swing.*;
import java.awt.*;

class EmployeeModel {
    String id = "", name = "", dept = "";
    String password = "admin123";

    boolean login(String u, String p) {
        return u.equals("admin") && p.equals(password);
    }
}

class EmployeeView extends JFrame {
    EmployeeModel model;
    JTextField user;
    JPasswordField pass;

    EmployeeView(EmployeeModel model) {
        this.model = model;

        setTitle("Employee Login");
        setSize(350, 200);
        setLayout(new GridLayout(3, 2));

        user = new JTextField();
        pass = new JPasswordField();
        JButton login = new JButton("Login");

        add(new JLabel("Username:"));
        add(user);
        add(new JLabel("Password:"));
        add(pass);
        add(new JLabel());
        add(login);

        login.addActionListener(e -> {
            if (model.login(user.getText(),
                    new String(pass.getPassword()))) {
                new MainWindow(model);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this,
                    "Invalid Username or Password");
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

class MainWindow extends JFrame {
    EmployeeModel model;

    MainWindow(EmployeeModel model) {
        this.model = model;

        setTitle("Employee Management Portal");
        setSize(500, 300);

        JMenuBar bar = new JMenuBar();

        JMenu employee = new JMenu("Employee");
        JMenu tools = new JMenu("Tools");
        JMenu exit = new JMenu("Exit");

        JMenuItem add = new JMenuItem("Add Employee");
        JMenuItem view = new JMenuItem("View Employee");
        JMenuItem change = new JMenuItem("Change Password");
        JMenuItem logout = new JMenuItem("Logout");
        JMenuItem exitApp = new JMenuItem("Exit Application");

        employee.add(add);
        employee.add(view);

        tools.add(change);

        exit.add(logout);
        exit.add(exitApp);

        bar.add(employee);
        bar.add(tools);
        bar.add(exit);

        setJMenuBar(bar);

        add.addActionListener(e -> addEmployee());
        view.addActionListener(e -> viewEmployee());
        change.addActionListener(e -> changePassword());

        logout.addActionListener(e -> {
            dispose();
            new EmployeeView(model);
        });

        exitApp.addActionListener(e -> System.exit(0));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    void addEmployee() {
        JPanel p = new JPanel(new GridLayout(3, 2));

        JTextField id = new JTextField();
        JTextField name = new JTextField();
        JTextField dept = new JTextField();

        p.add(new JLabel("Employee ID:"));
        p.add(id);
        p.add(new JLabel("Employee Name:"));
        p.add(name);
        p.add(new JLabel("Department:"));
        p.add(dept);

        int result = JOptionPane.showConfirmDialog(
            this, p, "Add Employee",
            JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            model.id = id.getText();
            model.name = name.getText();
            model.dept = dept.getText();

            JOptionPane.showMessageDialog(this,
                "Employee Added Successfully");
        }
    }

    void viewEmployee() {
        JOptionPane.showMessageDialog(this,
            "Employee ID: " + model.id +
            "\nName: " + model.name +
            "\nDepartment: " + model.dept);
    }

    void changePassword() {
        JPanel p = new JPanel(new GridLayout(3, 2));

        JPasswordField oldPass = new JPasswordField();
        JPasswordField newPass = new JPasswordField();
        JPasswordField confirm = new JPasswordField();

        p.add(new JLabel("Old Password:"));
        p.add(oldPass);
        p.add(new JLabel("New Password:"));
        p.add(newPass);
        p.add(new JLabel("Confirm Password:"));
        p.add(confirm);

        int result = JOptionPane.showConfirmDialog(
            this, p, "Change Password",
            JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String old = new String(oldPass.getPassword());
            String np = new String(newPass.getPassword());
            String cp = new String(confirm.getPassword());

            if (!old.equals(model.password))
                JOptionPane.showMessageDialog(this,
                    "Old Password Incorrect");
            else if (!np.equals(cp))
                JOptionPane.showMessageDialog(this,
                    "Passwords do not match");
            else {
                model.password = np;
                JOptionPane.showMessageDialog(this,
                    "Password Changed Successfully");
            }
        }
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        EmployeeModel model = new EmployeeModel();
        new EmployeeView(model);
    }
}
