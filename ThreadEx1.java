class MyRunnable implements Runnable {
    private final String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Thread " + name + " - Count: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread " + name + " interrupted.");
            }
        }
    }
}

public class ThreadEx1 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable("A"));
        Thread thread2 = new Thread(new MyRunnable("B"));

        thread1.start();
        thread2.start();
    }
}
