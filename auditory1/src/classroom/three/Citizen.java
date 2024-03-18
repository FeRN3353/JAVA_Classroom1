package classroom.three;

import java.util.Random;

class Citizen implements Runnable {
    private final String category;
    private final MFCWindow[] windows;
    private final Random random = new Random();
    private static int totalCustomers = 0;
    private static int angryYoungCustomers = 0;
    private static int angryOldCustomers = 0;
    private static int angryBusinessCustomers = 0;

    public Citizen(String category, MFCWindow[] windows) {
        this.category = category;
        this.windows = windows;
    }

    @Override
    public void run() {
        totalCustomers++;
        System.out.println("Гражданин категории " + category + " подошел к МФЦ.");

        int windowIndex;
        do {
            windowIndex = random.nextInt(windows.length);
        } while (category.equals("молодые") && windowIndex > 0);

        MFCWindow window = windows[windowIndex];

        if (!window.isBusy()) {
            System.out.println("Гражданин категории " + category + " обслуживается в окне " + (windowIndex + 1));
            window.serveCustomer();
            try {
                Thread.sleep(random.nextInt(30000) + 10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            window.releaseWindow();
        } else {
            System.out.println("Гражданин категории " + category + " ушел разгневанный.");
            switch (category) {
                case "молодые":
                    angryYoungCustomers++;
                    break;
                case "пожилые":
                    angryOldCustomers++;
                    break;
                case "бизнесмены":
                    angryBusinessCustomers++;
                    break;
            }
        }
    }

    public static void printAngryCustomersPercentages() {
        System.out.println("Процент ушедших молодых клиентов: " + (angryYoungCustomers * 100.0 / totalCustomers) + "%");
        System.out.println("Процент ушедших пожилых клиентов: " + (angryOldCustomers * 100.0 / totalCustomers) + "%");
        System.out.println("Процент ушедших бизнес-клиентов: " + (angryBusinessCustomers * 100.0 / totalCustomers) + "%");
    }
}
