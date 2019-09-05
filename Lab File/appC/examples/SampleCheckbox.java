import java.awt.*;
import java.awt.event.*;

public class SampleCheckbox implements ItemListener {
  private Frame f;
  private Checkbox one, two, three;

  public void go() {
    f = new Frame("Sample Checkbox");
    one = new Checkbox("One", true);
    two = new Checkbox("Two", false);
    three = new Checkbox("Three", false);

    one.addItemListener(this);
    two.addItemListener(this);
    three.addItemListener(this);

    f.setLayout(new FlowLayout());
    f.add(one);
    f.add(two);
    f.add(three);

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
    SampleCheckbox sampleCheckbox = new SampleCheckbox();
    sampleCheckbox.go();
  }
}
