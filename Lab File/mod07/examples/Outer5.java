public class Outer5 {
  private int size = 5;

  public Object makeTheInner(int localVar) {
    final int finalLocalVar = 6;

    // Declare an anonymous class within a method!?!
    Object o = new Object() {
      public String toString() {
	return ("#<Inner size=" + size + 
		// " localVar=" + localVar + // ERROR: ILLEGAL
		" finalLocalVar=" + finalLocalVar + ">");
      }
    };

    return o;
  }

  public static void main(String[] args) {
    Outer5 outer = new Outer5();
    Object obj = outer.makeTheInner(47);
    System.out.println("The object is " + obj);
  }
}
