package week9;

import javax.swing.*;
import java.awt.*;

class ServiceModel {
    int calculate(boolean general, boolean oil, boolean brake, boolean battery) {
        int cost = 0;

        if (general) cost += 1000;
        if (oil) cost += 800;
        if (brake) cost += 1200;
        if (battery) cost += 500;

        return cost;
    }
}

class ServiceView extends JFrame {
    JTextField reg = new JTextField();
    JComboBox<String> type =
        new JComboBox<>(new String[]{"Two Wheeler", "Car"});

    JCheckBox general = new JCheckBox("General Service - ₹1000");
    JCheckBox oil = new JCheckBox("Oil Change - ₹800");
    JCheckBox brake = new JCheckBox("Brake Service - ₹1200");
    JCheckBox battery = new JCheckBox("Battery Check - ₹500");

    JButton calculate = new JButton("Calculate Cost");

    ServiceView() {
        setTitle("Vehicle Service Cost Estimator");
        setSize(450, 350);
        setLayout(new GridLayout(7, 1));

        add(new JLabel("Vehicle Registration Number:"));
        add(reg);
        add(type);
        add(general);
        add(oil);
        add(brake);
        add(battery);
        add(calculate);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

class ServiceController {
    ServiceView view;
    ServiceModel model = new ServiceModel();

    ServiceController(ServiceView view) {
        this.view = view;

        view.calculate.addActionListener(e -> {
            int cost = model.calculate(
                view.general.isSelected(),
                view.oil.isSelected(),
                view.brake.isSelected(),
                view.battery.isSelected()
            );

            JOptionPane.showMessageDialog(view,
                "Registration No: " + view.reg.getText() +
                "\nVehicle: " + view.type.getSelectedItem() +
                "\nTotal Service Cost: ₹" + cost);
        });
    }
}

public class VehicleService {
    public static void main(String[] args) {
        ServiceView view = new ServiceView();
        new ServiceController(view);
    }
}
