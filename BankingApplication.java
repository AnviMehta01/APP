package week7;

class BankTask implements Runnable {
    String activity;

    BankTask(String activity) {
        this.activity = activity;
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName()
                    + " - " + activity + " - Execution " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class BankingApplication {
    public static void main(String[] args) {

        BankTask transaction =
                new BankTask("Transaction Processing");

        BankTask balance =
                new BankTask("Balance Updating");

        BankTask sms =
                new BankTask("SMS Notification");

        Thread t1 = new Thread(transaction);
        Thread t2 = new Thread(balance);
        Thread t3 = new Thread(sms);

        t1.setName("Transaction Thread");
        t2.setName("Balance Thread");
        t3.setName("SMS Thread");

        t1.start();
        t2.start();
        t3.start();
    }
}