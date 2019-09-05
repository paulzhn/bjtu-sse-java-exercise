public class TestCounter {
  public static void main(String[] args) {
    System.out.println("Number of counter is " + Count.getTotalCount());
    Count count1 = new Count();
    System.out.println("Number of counter is " + Count.getTotalCount());
  }
}
