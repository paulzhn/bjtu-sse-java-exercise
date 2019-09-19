public class Printer implements Runnable {
    private static Printer printerInstance;
    private Queue printQueue;
    private final Object lock = new Object();
    private boolean stateIsRunning;

    private Printer() {
        printQueue = new CircularQueue(10);
        stateIsRunning = true;
    }

    public static Printer getInstance() {
        if (printerInstance == null) {
            printerInstance = new Printer();
        }
        return printerInstance;
    }

    @Override
    public void run() {
        PrintJob now;
        System.out.println("\tC: Print manager is starting up.");

        synchronized (lock) {
            while (stateIsRunning) {
                try {
                    now = getJob();
                    System.out.println("\tC: Starting job '" + now.getName() + "'");
                    Thread.sleep(500 * now.getPages());
                    System.out.println("\tC: Completed job '" + now.getName() + "'");
                    lock.notifyAll();
                    Thread.sleep(100);

                } catch (EmptyQueueException | InterruptedException ignored) {
                }

            }
        }

        System.out.println("\tC: Print manager is halted.");
    }

    public synchronized void halt() {
        stateIsRunning = false;
    }

    public void addJob(PrintJob job) {
        synchronized (lock) {
            while (true) {
                try {
                    printQueue.addBack(job);
                    System.out.println("P: Adding job '" + job.getName() + "' to the queue");
                    lock.notifyAll();
                    break;
                } catch (FullQueueException e) {
                    System.out.println("P: The print queue is full!");
                    try {
                        lock.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }

    }

    private PrintJob getJob() throws EmptyQueueException, InterruptedException {
        synchronized (lock) {
            try {
                PrintJob a = (PrintJob)printQueue.getFront();
                printQueue.removeFront();
                return a;
            } catch (EmptyQueueException e) {

                System.out.println("\tC: Waiting on a job to print.");
                try {
                    lock.wait();
                } catch (InterruptedException ex) {
                    throw new InterruptedException();
                }
                throw new EmptyQueueException(printQueue);
            }
        }
    }
}
