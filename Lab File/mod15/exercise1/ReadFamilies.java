import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class ReadFamilies {
  public static void main(String[] args) {
    Family family1;
    Family family2;
    Family family3;
    Person pat_willcutt;
    Person bryan_basham;

    try {
      /***
      **** Step 8: declare and initialize input stream objects
      ***/

      /***
      **** Step 9: read the three families from the object stream
      **** Don't forget to close the top-level stream when done.
      ***/

      pat_willcutt = family1.findChild("Pat");
      bryan_basham = family3.findChild("Bryan");

      // queries
      System.out.println("Pat Willcutt has " + pat_willcutt.getNumberOfSiblings() + " sibilings.");
      System.out.println("Bryan Basham has " + bryan_basham.getNumberOfSiblings() + " sibilings.");

      // Handle exceptions
    } catch (IOException e1) {
      e1.printStackTrace();
    } catch (ClassNotFoundException e2) {
      e2.printStackTrace();
    }
  }
}
