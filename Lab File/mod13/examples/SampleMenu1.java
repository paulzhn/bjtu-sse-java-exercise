import java.awt.*;
import java.awt.event.*;

public class SampleMenu1 {
  private Frame f;
  private MenuBar mb;

  public void go() {
    f = new Frame("MenuBar");
    mb = new MenuBar();
    f.setMenuBar(mb);

    f.setSize(200,200);
    f.setVisible(true);
  }

  public static void main (String args[]) {
    SampleMenu1 sampleMenu = new SampleMenu1();
    sampleMenu.go();
  }
}
