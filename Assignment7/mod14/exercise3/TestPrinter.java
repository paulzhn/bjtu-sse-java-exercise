public class TestPrinter {
    public static void main(String[] args) {
        Producer small, middle, large;
        Printer printer = Printer.getInstance();
        /*small = new Producer(5, 5, 2, "Small");
        middle = new Producer(15, 10, 5, "Middle");
        large = new Producer(25, 15, 10, "Large");*/
        small = new Producer(1, 1, 1, "Small");
        middle = new Producer(1, 1, 2, "Middle");
        large = new Producer(1, 1, 3, "Large");
        Thread s = new Thread(small, "small");
        Thread m = new Thread(middle, "middle");
        Thread l = new Thread(large, "large");
        Thread p = new Thread(printer, "printer");
        p.setPriority(Thread.MAX_PRIORITY);
        p.start();
        s.start();
        m.start();
        l.start();
        try {
            s.join();
            m.join();
            l.join();
            while (true) {
                if (p.getState() == Thread.State.WAITING) {
                    printer.halt();
                    p.interrupt();
                    break;
                }
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
