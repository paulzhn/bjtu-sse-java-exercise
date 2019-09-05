import java.awt.*;
import java.awt.event.*;

public class SampleButton implements ActionListener {
  private Frame f;
  private Button b;

  public void go() {
    f = new Frame("Sample Button");
    b = new Button("Sample");
    b.addActionListener(this);
    f.add(b);
    f.pack();
    f.setVisible(true);
  }

  public void actionPerformed( ActionEvent ae) {
    System.out.println("Button press received.");
    System.out.println("Button's action command is: "+
        ae.getActionCommand());
  }

  public static void main (String args[]) {
    SampleButton sampleButton = new SampleButton();
    sampleButton.go();
  }
}
