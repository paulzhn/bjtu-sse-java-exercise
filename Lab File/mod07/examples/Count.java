public class Count {
  private int serialNumber;
  public static int counter;

  static {
    counter = Integer.getInteger("myApp.Count.counter").intValue();
  }

  public static int getTotalCount() {
    return counter;
  }
  public Count() {
    counter++;
    serialNumber = counter;
  }
}
