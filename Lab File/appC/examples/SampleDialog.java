import java.awt.*;
import java.awt.event.*;

public class SampleDialog implements ActionListener {

  private Frame f;
  private Dialog d;
  private Panel dp;
  private Button db1;
  private Button db2;
  private Label dl;
  private Button b;

  public void go() {
    f = new Frame("SampleDialog");

    // Set up dialog.
    d = new Dialog(f, "Dialog box", true);
    dp = new Panel();
    dp.setLayout(new FlowLayout());
    db1 = new Button("OK");
    db2 = new Button("Not on your life!!!");
    dp.add(db1);
    dp.add(db2);
    dl = new Label (
      "Are you absolutely sure you want to do this?");
    d.add(dl,BorderLayout.NORTH);
    d.add(dp,BorderLayout.SOUTH);
    d.pack();

    b = new Button("Self Destruct");

    // Register listener for buttons.
    b.addActionListener(this);
    db1.addActionListener(this);
    db2.addActionListener(this);

    f.add(b, BorderLayout.CENTER);
    f.setSize(400,400);
    f.setVisible(true);
  }

  // Handler for all buttons.
  public void actionPerformed( ActionEvent ae) {
    String buttonPressed = ae.getActionCommand();
    if (buttonPressed.equals("Self Destruct")) {
      d.setVisible(true);
    } else if (buttonPressed.equals("OK")) {
      System.out.println ("Process terminated!!!");
      System.exit(0);
    } else {
      d.setVisible(false);
    }
  }

  public static void main (String args[]) {
    SampleDialog sampleDialog = new SampleDialog();
    sampleDialog.go();
  }
}
