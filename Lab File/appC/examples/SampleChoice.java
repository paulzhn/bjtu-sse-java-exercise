import java.awt.*;
import java.awt.event.*;

public class SampleChoice implements ItemListener {
  private Frame f;
  private Choice choice;

  public void go() {
    f = new Frame("Sample Choice");
    choice = new Choice();
    choice.addItem("First");
    choice.addItem("Second");
    choice.addItem("Third");
    choice.addItemListener(this);
    f.add(choice, BorderLayout.CENTER);
    f.pack();
    f.setVisible(true);
  }

  public void itemStateChanged(ItemEvent ev) {
    String state = "deselected";
    if (ev.getStateChange() == ItemEvent.SELECTED) {
      state = "selected";
    }
    System.out.println (ev.getItem() + " " + state);
  }

  public static void main (String args[]) {
    SampleChoice sampleChoice = new SampleChoice();
    sampleChoice.go();
  }
}
