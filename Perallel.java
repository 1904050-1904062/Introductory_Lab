public class Perallel {
    static class Task implements Runnable {
        private String name;
        private int duration; // Simulated duration
        
        public Task(String name, int duration) {
            this.name = name;
            this.duration = duration;
        }
        
        @Override
        public void run() {
            System.out.println("Task " + name + " started.");
            try {
                Thread.sleep(duration); // Simulate task execution time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task " + name + " completed.");
        }
    }
    
    public static void main(String[] args) {
        // Define tasks with their durations
        Task task1 = new Task("Task 1", 2000); // 2 seconds
        Task task2 = new Task("Task 2", 3000); // 3 seconds
        Task task3 = new Task("Task 3", 1500); // 1.5 seconds
        
        // Create threads for each task
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);
        
        // Start the threads
        thread1.start();
        thread2.start();
        thread3.start();
        
        // Wait for all threads to complete
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("All tasks completed.");
    }
}
