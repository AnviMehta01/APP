package week7;

class TrafficJunction extends Thread {
    String status;
    int delay;

    TrafficJunction(String name, String status, int delay) {
        setName(name);
        this.status = status;
        this.delay = delay;
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName()
                    + " - Traffic Status: " + status);

            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class SmartTraffic {
    public static void main(String[] args) {

        TrafficJunction j1 =
                new TrafficJunction("Junction 1", "Heavy Traffic", 1000);

        TrafficJunction j2 =
                new TrafficJunction("Junction 2", "Moderate Traffic", 1500);

        TrafficJunction j3 =
                new TrafficJunction("Junction 3", "Low Traffic", 2000);

        j1.start();
        j2.start();
        j3.start();
    }
}