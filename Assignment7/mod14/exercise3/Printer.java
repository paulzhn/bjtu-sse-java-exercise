public class Printer implements Runnable {
    private static Printer printerInstance;
    private Queue printQueue;
    private boolean stateIsRunning;

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
        System.out.println("/tC: Print manager is starting up.");
        while (stateIsRunning) {
            while (printQueue.isEmpty()) {
                System.out.println("/tC: Waiting on a job to print.");
            }

        }
    }

    public synchronized void halt() {
        stateIsRunning = false;
    }

    public synchronized void addJob(PrintJob job) throws FullQueueException {
        boolean thrown = false;
        try {
            printQueue.addBack(job);
            System.out.println("P: Adding job '" + job.getName() + "' to the queue");
        } catch (FullQueueException e) {
            System.out.println("The print queue is full!");

        }


    }

    private synchronized PrintJob getJob() throws EmptyQueueException {

        PrintJob a = (PrintJob)printQueue.getFront();
        printQueue.removeFront();
        return a;
    }
}
