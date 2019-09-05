// <APPLET CODE="PaintModel2.class" WIDTH=200 HEIGHT=200></APPLET>

import java.applet.*;
import java.awt.event.*;
import java.awt.*;

public class PaintModel2 extends Applet {
  // The paint model: the last click Point
  private Point lastClick = null;

  public void init() {
    addMouseListener(new MyModelRecorder());
  }

  public void update(Graphics g) {
    paint(g);
  }

  public void paint(Graphics g) {
    if ( lastClick != null ) {
      g.drawString("Hello World!", lastClick.x, lastClick.y);
    }
  }

  private class MyModelRecorder extends MouseAdapter {
    public void mousePressed(MouseEvent e) {
      lastClick = e.getPoint();
      repaint();
    }
  }
}
