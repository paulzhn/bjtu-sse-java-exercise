public class Outer3 {
  private int size;

  public class Inner {
    private int size;

    public void doStuff(int size) {
      size++;             // the local parameter
      this.size++;        // the Inner object attribute
      Outer3.this.size++;  // the Outer object attribute
    }
  }
}
