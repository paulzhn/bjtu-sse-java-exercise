import java.awt.*;
import java.applet.*;

public class DrawAny extends Applet {
  Image im;

  public void init() {
    String imageName = getParameter("image");

    if ( imageName != null ) {
      im = getImage(getDocumentBase(), imageName);
    }
    else {
      System.err.println("Error: Cannot find image");
    }
  }

  public void paint(Graphics g) {
    if ( im != null ) {
      g.drawImage(im, 0, 0, this);
    } else {
      g.setColor(Color.red);
      g.drawString("Error: Cannot find image", 25, 25);
    }
  }
}
