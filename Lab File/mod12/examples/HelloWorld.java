import java.awt.Graphics;
import java.applet.Applet;

public class HelloWorld extends Applet {
  private int paintCount;
  public void init() {
    paintCount = 0;
  }
  public void paint(Graphics g){
    g.drawString("Hello World", 25, 25);
    ++paintCount;
    g.drawString("Number of times paint called: " + paintCount, 25, 50);
  }
}
