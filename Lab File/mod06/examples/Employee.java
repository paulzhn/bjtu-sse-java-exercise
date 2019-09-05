class Employee {

  private String name;
  private MyDate birthDate;
  private float  salary;

  // Constructor
  public Employee(String name, MyDate DoB, float salary) {
    this.name = name;
    this.birthDate = DoB;
    this.salary = salary;
  }
  
  //public Employee(){};

  public boolean equals(Object o) {
    boolean result = false;
    if ( (o != null) && (o instanceof Employee) ) {
      Employee e = (Employee) o;
      if (   name.equals(e.name)
	  && birthDate.equals(e.birthDate) ) {
	result = true;
      }
    }
    return result;
  }

  public int hashCode() {
    return ( name.hashCode() ^ birthDate.hashCode() );
  }
}
