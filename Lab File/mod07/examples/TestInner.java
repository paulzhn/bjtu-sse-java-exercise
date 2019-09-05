public class TestInner {
  public static void main(String[] args) {
    Outer2 outer = new Outer2();

    // Must create an Inner object relative to an Outer
    Inner inner = outer.new Inner();
    inner.doStuff();
  }
}
