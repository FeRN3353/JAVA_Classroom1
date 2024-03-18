package classroom.two;

import java.util.concurrent.CopyOnWriteArrayList;

class Reader implements Runnable {
    private final CopyOnWriteArrayList<Integer> listOfNumbers;

    public Reader(CopyOnWriteArrayList<Integer> listOfNumbers) {
        this.listOfNumbers = listOfNumbers;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(500); // Небольшая задержка для чтения
                System.out.println("Reading from list: " + listOfNumbers);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}