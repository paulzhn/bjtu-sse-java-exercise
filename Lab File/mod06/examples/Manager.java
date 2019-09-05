class Manager extends Employee {
  private String department;

  public Manager(String name, MyDate DoB,
		 float salary, String dept) {
    super(name, DoB, salary);
    this.department = dept;
  }
  
  public Manager(String dept){
	  super();
	  department=dept;
  }
}
