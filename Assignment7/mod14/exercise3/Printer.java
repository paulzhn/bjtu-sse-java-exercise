public class Printer implements Runnable {
    private Queue printQueue;
    private boolean stateIsRunning;
    private static Printer printerInstance;

    private Printer() {
        printQueue = new CircularQueue(10);
        stateIsRunning = false;
    }

    public static Printer getInstance() {
        if (printerInstance == null) {
            printerInstance = new Printer();
        }
        return printerInstance;
    }

    @Override
    public void run() {
        // todo
    }

    public synchronized void halt() {
        stateIsRunning = false;
    }

    public synchronized void addJob(PrintJob job) throws FullQueueException {
        printQueue.addBack(job);
    }

    private synchronized PrintJob getJob() throws EmptyQueueException {
        return (PrintJob) printQueue.getFront();
    }
}
