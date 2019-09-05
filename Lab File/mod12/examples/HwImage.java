// Applet which shows an image of Duke in surfing mode

import java.awt.*;
import java.applet.Applet;

public class HwImage extends Applet {
  Image duke;

  public void init() {
    duke = getImage(getDocumentBase(),
        "graphics/surferDuke.gif");
  }

  public void paint(Graphics g) {
    g.drawImage(duke, 25, 25, this);
  }
}
