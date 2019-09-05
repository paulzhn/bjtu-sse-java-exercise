import java.awt.*;
import java.awt.event.*;

public class MyList {
  private Frame f;
  private List list;

  public void go() {
    f = new Frame("List");
    list = new List(4, true);
		list.add("Hello");
		list.add("there");
		list.add("how");
    f.add(list, BorderLayout.CENTER);
    f.pack();
    f.setVisible(true);
  }

  public static void main (String args[]) {
    MyList ml = new MyList();
    ml.go();
  }
}
