// Applet which continuously repeats a sound

import java.awt.Graphics;
import java.applet.*;

public class HwLoop extends Applet {
	AudioClip sound;

	public void init() {
		sound = getAudioClip(getCodeBase(), "sounds/cuckoo.au");
	}

	public void paint(Graphics g) {
		g.drawString("Audio Test", 25, 25);
	}

	public void start() {
		sound.loop();
	}

	public void stop() {
		sound.stop();
	}
}
