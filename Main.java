// Define a class that extends Thread
class MyThread extends Thread {
    public void run() {
        // Define the task that this thread will execute
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread running: " + i);
            try {
                // Introduce a small delay to simulate processing
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Create instances of MyThread
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();

        // Start the threads
        thread1.start();
        thread2.start();
    }
}
