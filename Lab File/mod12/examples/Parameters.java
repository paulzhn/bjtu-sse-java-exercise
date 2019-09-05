// Parameter test applet. To see a change in "speed", 
// you must supply it as a <param> tag in the HTML file 
// which calls this applet.

import java.applet.Applet;
import java.awt.Graphics;

public class Parameters extends Applet {
  private String toDisplay;
  private int speed;

  public void init() {
    String pv;
    pv = getParameter("speed");
    if (pv == null){
      speed = 10;
    } else {
      speed = Integer.parseInt (pv);
    }
    toDisplay = "Speed given: " + speed;
  }

  public void paint(Graphics g) {
    g.drawString(toDisplay, 25, 25);
  }
}
