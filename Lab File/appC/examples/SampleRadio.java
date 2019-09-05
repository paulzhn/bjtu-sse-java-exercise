import java.awt.*;
import java.awt.event.*;

public class SampleRadio implements ItemListener {
  private Frame f;
  private CheckboxGroup cbg;
  private Checkbox one;
  private Checkbox two;
  private Checkbox three;

  public void go() {
    f = new Frame("CheckBoxGroup");
    cbg = new CheckboxGroup();
    one = new Checkbox("One", cbg, false);
    two = new Checkbox("Two", cbg, false);
    three = new Checkbox("Three", cbg, true);

    f.setLayout(new FlowLayout());

    one.addItemListener(this);
    two.addItemListener(this);
    three.addItemListener(this);

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
    SampleRadio sampleRadio = new SampleRadio();
    sampleRadio.go();
  }
}
