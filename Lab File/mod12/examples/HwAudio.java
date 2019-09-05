// Applet which plays a sound on every mouse click

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.applet.Applet;

public class HwAudio extends Applet {
  public void init() {
    addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent event) {
	play(getCodeBase(), "sounds/cuckoo.au");
      }
    });
  }
  public void paint(Graphics g) {
    g.drawString("Audio Test", 25, 25);
  }
}
