// <APPLET CODE="PaintModel3.class" WIDTH=200 HEIGHT=200></APPLET>

import java.applet.*;
import java.awt.event.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class PaintModel3 extends Applet {
  // The paint model: a list of click Points
  private List mouseClicks = new ArrayList(5);

  public void init() {
    addMouseListener(new MyModelRecorder());
  }

  public void update(Graphics g) {
    paint(g);
  }

  public void paint(Graphics g) {
    for(int x = 0; x < mouseClicks.size(); x++) {
      Point p = (Point) mouseClicks.get(x);
      g.drawString("Hello World!", p.x, p.y);
    }
  }

  private class MyModelRecorder extends MouseAdapter {
    public void mousePressed(MouseEvent e) {
      mouseClicks.add(e.getPoint());
      repaint();
    }
  }
}
