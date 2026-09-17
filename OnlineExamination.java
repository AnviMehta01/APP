package week7;

class ExamTask implements Runnable {
    String activity;

    ExamTask(String activity) {
        this.activity = activity;
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName()
                    + " - " + activity);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class OnlineExamination {
    public static void main(String[] args) {

        ExamTask time = new ExamTask("Displaying remaining time");
        ExamTask save = new ExamTask("Auto-saving answers");
        ExamTask network = new ExamTask("Checking network connection");

        Thread t1 = new Thread(time);
        Thread t2 = new Thread(save);
        Thread t3 = new Thread(network);

        t1.setName("Time Thread");
        t2.setName("Save Thread");
        t3.setName("Network Thread");

        t1.start();
        t2.start();
        t3.start();
    }
}
