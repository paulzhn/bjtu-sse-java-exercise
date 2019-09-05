class TestEquals {
  public static void main(String[] args) {
    Employee  emp1 = new Employee("Fred Smith",
				  new MyDate(14, 3, 1976),
				  25000.0F);
    Employee  emp2 = new Employee("Fred Smith",
				  new MyDate(14, 3, 1976),
				  25000.0F);

    if ( emp1 == emp2 ) {
      System.out.println("emp1 is identical to emp2");
    } else {
      System.out.println("emp1 is not identical to emp2");
    }

    if ( emp1.equals(emp2) ) {
      System.out.println("emp1 is equal to emp2");
    } else {
      System.out.println("emp1 is not equal to emp2");
    }

    emp2 = emp1;
    System.out.println("set emp2 = emp1;");
    if ( emp1 == emp2 ) {
      System.out.println("emp1 is identical to emp2");
    } else {
      System.out.println("emp1 is not identical to emp2");
    }
  }
}
