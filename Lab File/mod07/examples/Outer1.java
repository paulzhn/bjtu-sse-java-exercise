public class Outer1 {
  private int size;

  /* Declare an inner class called "Inner" */
  public class Inner {
    public void doStuff() {
      // The inner class has access to 'size' from Outer
      size++;
    }
  }

  public void testTheInner() {
    Inner i = new Inner();
    i.doStuff();
  }
}
