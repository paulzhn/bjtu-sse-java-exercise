import java.awt.*;
import java.awt.event.*;

public class SamplePopup extends WindowAdapter implements ActionListener
{
  private Frame f = new Frame("PopupMenu");
  private Button b = new Button("Press Me");
  private PopupMenu p = new PopupMenu("Popup");
  private MenuItem s = new MenuItem("Save");
  private MenuItem ld = new MenuItem("Load");

  public void go()
  {
    f.setSize(100,100);
    b.addActionListener(this);
    b.setSize(100,100);
    f.add(b,BorderLayout.CENTER);
    p.add(s);
    p.add(ld);
    f.add(p);
    f.pack();
    f.setVisible(true);
  }

  public void actionPerformed(ActionEvent ev)
  {
    if ( ev.getSource() == b )
      { p.show(b,10,10); }
    else
      { System.out.println("Menu item pressed was " + ev.toString()); }
  }

  public void windowOpened(WindowEvent ev)
  {
    System.out.println("Window opened.");
  }

  public void windowClosed(WindowEvent ev)
  {
    System.out.println("Window closed.");
    System.exit(0);
  }

  public static void main (String args[])
  {
    SamplePopup samplePopup = new SamplePopup();
    samplePopup.go();
  }
}
