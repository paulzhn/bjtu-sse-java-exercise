// This applet is HelloWorld extended to watch for mouse 
// input. "Hello World!" is reprinted at the location of 
// the mouse press.

import java.awt.Graphics;
import java.awt.event.*;
import java.applet.Applet;

public class HwMouse extends Applet {
  // "paint model data"
  private int mouseX = 25;
  private int mouseY = 25;

  // Register an anonymous mouse events handler.
  public void init() {
    addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent evt) {
	// record the position of the mouse
	// in the "paint model data"
	mouseX = evt.getX();
	mouseY = evt.getY();
	// inform AWT to repaint the applet
	repaint();
      }
    });
  }       

  public void paint(Graphics g) {
    g.drawString("Hello World!", mouseX, mouseY);
  }
}
