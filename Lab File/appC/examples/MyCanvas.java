import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MyCanvas extends Canvas 
      implements KeyListener{
  private int index;
  Color colors[] = { Color.red, Color.green, Color.blue };

  public void paint(Graphics g) {
    g.setColor(colors[ index ]);
    g.fillRect(0, 0, getSize().width, getSize().height);
  }

  public void keyTyped(KeyEvent ev) {
    index++;
    if ( index == colors.length ) {
      index = 0;
    }
    repaint();
  }

  // Unused KeyListener methods
  public void keyPressed(KeyEvent ev) { }
  public void keyReleased(KeyEvent ev) { }

  public static void main(String args[]) {
    Frame f = new Frame("Canvas");
    MyCanvas mc = new MyCanvas();
    mc.setSize(150, 150);
    f.add(mc, BorderLayout.CENTER);
    mc.requestFocus();
    mc.addKeyListener(mc);
    f.pack();
    f.setVisible(true);
  }
}
