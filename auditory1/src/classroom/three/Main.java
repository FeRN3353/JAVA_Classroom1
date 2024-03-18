package classroom.three;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MFCWindow[] windows = {new MFCWindow(), new MFCWindow(), new MFCWindow()};
        String[] categories = {"молодые", "пожилые", "бизнесмены"};

        for (int i = 0; i < 100; i++) {
            String category = categories[new Random().nextInt(categories.length)];
            new Thread(new Citizen(category, windows)).start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Citizen.printAngryCustomersPercentages();
    }
}