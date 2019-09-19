
public class Producer implements Runnable {
    private int sizeOfJobs;
    private int numberOfJobs;
    private int delayBetweenJobs;
    private String producerName;

    public Producer(int sizeOfJobs, int numberOfJobs, int delayBetweenJobs, String producerName) {
        this.sizeOfJobs = sizeOfJobs;
        this.numberOfJobs = numberOfJobs;
        this.delayBetweenJobs = delayBetweenJobs;
        this.producerName = producerName;
    }

    @Override
    public synchronized void run() {
        PrintJob job;
        for (int i = 0; i < numberOfJobs; i++) {
            job = new PrintJob(producerName + " #" + (i + 1), sizeOfJobs);
            Printer.getInstance().addJob(job);
            try {
                Thread.sleep(delayBetweenJobs);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
