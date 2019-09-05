package mod08.exercise1;

public class TestExceptions {
    public static void main(String[] args) {
        try {
            for (int i = 0; true; i++) {

                System.out.println("args[" + i + "] is '" + args[i] + "'");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
