package classroom.three;

public class MFCWindow {
    private boolean isBusy = false;

    public synchronized boolean isBusy() {
        return isBusy;
    }

    public synchronized void serveCustomer() {
        isBusy = true;
    }

    public synchronized void releaseWindow() {
        isBusy = false;
    }
}

