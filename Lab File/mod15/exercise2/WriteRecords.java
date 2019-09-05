/***
**** What classes need to be imported?
***/
import java.io.IOException;

public class WriteRecords {
  public static void main(String[] args) {
    Record rec1 = new Record("record #1", 2, Math.sqrt(2));
    Record rec2 = new Record("record #2", 3, Math.E);
    Record rec3 = new Record("record #3", 5, Math.PI);
    Record rec4 = new Record("record #4", 7, 4.0);
    Record rec5 = new Record("record #5", 9, Math.E + Math.PI);

    try {
      /***
      **** Step 1: declare and initialize the record output stream
      ***/

      /***
      **** Step 2: write the five records to the record output stream
      **** Don't forget to close the top-level stream.
      ***/

      System.out.println("Five records have been saved to the 'record.db' file.");

      // Handle excpetions
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
