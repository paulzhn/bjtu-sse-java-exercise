import java.awt.*;
import java.awt.event.*;

public class MyDialog implements ActionListener {

  private Frame f;
  private Dialog d;
  private Button db1;
  private Label dl;
  private Button b;

  public void go() {
    f = new Frame("Dialog");

    // Set up dialog.
    d = new Dialog(f, "Dialog", true);
    d.setLayout(new GridLayout(2,1));
    dl = new Label("Hello, I'm a Dialog");
    db1 = new Button("OK");
    d.add(dl);
    d.add(db1);
    d.pack();

    b = new Button("Launch Dialog");

    // Register listener for buttons.
    b.addActionListener(this);
    db1.addActionListener(this);

    f.add(b, BorderLayout.CENTER);
    f.pack();
    f.setVisible(true);
  }

  // Handler for all buttons.
  public void actionPerformed( ActionEvent ae) {
    String buttonPressed = ae.getActionCommand();
    if (buttonPressed.equals("Launch Dialog")) {
      d.setVisible(true);
    } else if (buttonPressed.equals("OK")) {
      System.out.println ("Process terminated!!!");
      System.exit(0);
    } else {
      d.setVisible(false);
    }
  }

  public static void main (String args[]) {
    MyDialog myDialog = new MyDialog();
    myDialog.go();
  }
}
