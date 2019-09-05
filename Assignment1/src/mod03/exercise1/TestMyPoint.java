package mod03.exercise1;

public class TestMyPoint {
    public static void main(String[] args) {
        MyPoint start = new MyPoint();
        start.x = 10;
        start.y = 10;

        MyPoint end = new MyPoint();
        end.x = 20;
        end.y = 30;

        MyPoint stray = end;

        stray.x = 47;
        stray.y = 30;

        System.out.println("Start point is " + start);
        System.out.println("End point is " + end + "\n");

        System.out.println("Stray point is " + stray);
        System.out.println("End point is " + end + "\n");

        System.out.println("Stray point is " + stray);
        System.out.println("End point is " + end);
        System.out.println("Start point is " + start);


    }
}
