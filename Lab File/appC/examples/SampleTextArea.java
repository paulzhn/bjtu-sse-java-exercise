import java.awt.*;
import java.awt.event.*;

public class SampleTextArea {
  private Frame f;
  private TextArea ta;

  public void go() {
    f = new Frame("TextArea");
    ta = new TextArea("Hello!", 4, 30);
    f.add(ta, BorderLayout.CENTER);
    f.pack();
    f.setVisible(true);
  }

  public static void main (String args[]) {
    SampleTextArea sampleTextArea = new SampleTextArea();
    sampleTextArea.go();
  }
}
