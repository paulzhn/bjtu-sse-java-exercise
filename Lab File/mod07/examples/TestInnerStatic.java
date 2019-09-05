public class TestInnerStatic {
  public class InnerClass {
    public static int classVar = 0;
    public static void doSomething() {
      System.out.println("TestInnerStatic.InnerClass.doSomething");
    }
  }

  public static void main(String[] args) {
    InnerClass.doSomething();
  }
}
