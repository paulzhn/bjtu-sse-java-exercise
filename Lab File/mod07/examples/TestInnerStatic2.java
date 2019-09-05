public class TestInnerStatic2 {
  public static final int CONSTANT = 47;
  public  class InnerClass {
    public void doSomething() {
      System.out.println("TestInnerStatic2.InnerClass.doSomething = " + CONSTANT);
    }
  }

  public static void main(String[] args) {
    InnerClass obj = (new TestInnerStatic2()).new InnerClass();

    obj.doSomething();
  }
}
