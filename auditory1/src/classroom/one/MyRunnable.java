package classroom.one;

public class MyRunnable implements Runnable {

    public void run() {
        long threadId = Thread.currentThread().getId();
        System.out.println("Thread ID: " + threadId);
    }
}