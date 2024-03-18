package classroom.two;

import java.util.concurrent.CopyOnWriteArrayList;

class Writer implements Runnable {
    private final CopyOnWriteArrayList<Integer> listOfNumbers;

    public Writer(CopyOnWriteArrayList<Integer> listOfNumbers) {
        this.listOfNumbers = listOfNumbers;
    }

    @Override
    public void run() {
        int count = 1;
        while (true) {
            try {
                Thread.sleep(1500);
                listOfNumbers.add(count++);
                System.out.println("Added: " + (count - 1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
