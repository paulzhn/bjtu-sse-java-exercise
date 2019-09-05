public class Outer4 {
  private int size = 5;

  public Object makeTheInner(int localVar) {
    final int finalLocalVar = 6;

    // Declare a class within a method!?!
    class Inner {
      public String toString() {
	return ("#<Inner size=" + size + 
		// " localVar=" + localVar + // ERROR: ILLEGAL
		" finalLocalVar=" + finalLocalVar + ">");
      }
    }

    return new Inner();
  }

  public static void main(String[] args) {
    Outer4 outer = new Outer4();
    Object obj = outer.makeTheInner(47);
    System.out.println("The object is " + obj);
  }
}
