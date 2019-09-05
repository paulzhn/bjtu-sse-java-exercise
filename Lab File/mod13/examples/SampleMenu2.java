import java.awt.*;
import java.awt.event.*;

public class SampleMenu2 {
  private Frame f;
  private MenuBar mb;
  private Menu m1;
  private Menu m2;
  private Menu m3;

  public void go() {
    f = new Frame("Menu");
    mb = new MenuBar();
    m1 = new Menu("File");
    m2 = new Menu("Edit");
    m3 = new Menu("Help");
    mb.add(m1);
    mb.add(m2);
    mb.setHelpMenu(m3);
    f.setMenuBar(mb);

    f.setSize(200,200);
    f.setVisible(true);
  }

  public static void main (String args[]) {
    SampleMenu2 sampleMenu = new SampleMenu2();
    sampleMenu.go();
  }
}
