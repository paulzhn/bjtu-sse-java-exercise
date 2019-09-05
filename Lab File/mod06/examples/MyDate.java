class MyDate {
  private int day;
  private int month;
  private int year;

  public MyDate(int day, int month, int year) {
    this.day   = day;
    this.month = month;
    this.year  = year;
  }
  public MyDate() {
    this(1, 1, 1970);
  }
  public MyDate(MyDate date) {
    this.day   = date.day;
    this.month = date.month;
    this.year  = date.year;
  }

  public boolean equals(MyDate d) {
    boolean result = false;
    if ( d != null ) {
      if ( (day == d.day) && (month == d.month)
	   && (year == d.year) ) {
        result = true;
      }
    }
    return result;
  }

  public int hashCode() {
    return (   (new Integer(day).hashCode())
	     ^ (new Integer(month).hashCode())
	     ^ (new Integer(year).hashCode())
	   );
  }
}
