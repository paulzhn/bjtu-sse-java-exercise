

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
    public void run() {
        PrintJob[] jobs = new PrintJob[numberOfJobs];
        for (int i = 0; i < numberOfJobs; i++) {
            jobs[i] = new PrintJob(producerName + " #" + (i + 1), sizeOfJobs);
            try {
                Printer.getInstance().addJob(jobs[i]);
            } catch (FullQueueException e) {
                System.err.println("The print queue is full!");
            } finally {
                try {
                    Thread.sleep(delayBetweenJobs);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }



    }
}
