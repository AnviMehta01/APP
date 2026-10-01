package week8;

class OrderProcessing extends Thread {
    public void run() {
        System.out.println(getName() + " Priority: " + getPriority());
        System.out.println("Processing customer orders");
    }
}

class DeliveryTracking extends Thread {
    public void run() {
        System.out.println(getName() + " Priority: " + getPriority());
        System.out.println("Tracking delivery location");
    }
}

class Notification extends Thread {
    public void run() {
        System.out.println(getName() + " Priority: " + getPriority());
        System.out.println("Sending order-status notification");
    }
}

public class FoodDelivery {
    public static void main(String[] args) {
        OrderProcessing o = new OrderProcessing();
        DeliveryTracking d = new DeliveryTracking();
        Notification n = new Notification();

        o.setName("OrderProcessing");
        d.setName("DeliveryTracking");
        n.setName("Notification");

        o.setPriority(10);
        d.setPriority(5);
        n.setPriority(1);

        o.start();
        d.start();
        n.start();
    }
}