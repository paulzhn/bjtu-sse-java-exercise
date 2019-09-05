import java.awt.*;
import java.awt.event.*;

public class SampleTextField {
  private Frame f;
  private TextField tf;

  public void go() {
    f = new Frame("TextField");
    tf = new TextField("Single Line", 30);
    tf.addKeyListener( new NameHandler() );
    f.add(tf, BorderLayout.CENTER);
    f.pack();
    f.setVisible(true);
  }

  class NameHandler extends KeyAdapter {
    public void keyPressed(KeyEvent e) {
      char c = e.getKeyChar();
      if ( Character.isDigit(c)) {
        e.consume();
      }
    }
  }

  public static void main (String args[]) {
    SampleTextField txtf = new SampleTextField();
    txtf.go();
  }
}
