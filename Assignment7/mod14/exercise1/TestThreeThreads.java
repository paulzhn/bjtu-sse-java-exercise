package exercise1;

public class TestThreeThreads {
    public static void main(String[] args) {
        PrintMe a = new PrintMe();
        Thread t1 = new Thread(a);
        Thread t2 = new Thread(a);
        Thread t3 = new Thread(a);
        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");
        t1.start();
        t2.start();
        t3.start();
    }
}
