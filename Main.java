// // Define a class that extends Thread
// class MyThread extends Thread {
//     public void run() {
//         // Define the task that this thread will execute
//         for (int i = 0; i < 5; i++) {
//             System.out.println("Thread running: " + i);
//             try {
//                 // Introduce a small delay to simulate processing
//                 Thread.sleep(1000);
//             } catch (InterruptedException e) {
//                 System.out.println("Thread interrupted.");
//             }
//         }
//     }
// }

// public class Main {
//     public static void main(String[] args) {
//         // Create instances of MyThread
//         MyThread thread1 = new MyThread();
//         MyThread thread2 = new MyThread();

//         // Start the threads
//         thread1.start();
//         thread2.start();
//     }
// }

class Counter {
    private int count = 0;

    public void increment() {
        synchronized (this) {
            count++;
            System.out.println(Thread.currentThread().getName() + " incremented count to " + count);
        }
    }

    public int getCount() {
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();

        // Create multiple threads
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                counter.increment();
                try {
                    Thread.sleep(5000); // Sleep for 500 milliseconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread 1");

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                counter.increment();
                try {
                    Thread.sleep(500); // Sleep for 500 milliseconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread 2");

        // Start the threads
        thread1.start();
        thread2.start();

        // Wait for threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // After threads have finished, print the final count
        System.out.println("Final count: " + counter.getCount());
    }
}
