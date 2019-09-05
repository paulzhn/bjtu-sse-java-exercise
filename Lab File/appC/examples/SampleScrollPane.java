import java.awt.*;

public class SampleScrollPane {
  private Frame f;
  private Button b1, b2, b3, b4, b5, b6; 
  private Button b7, b8, b9, b10, b11, b12;
  private Panel p;
  private ScrollPane sp;

  public void go() {
    f = new Frame("Sample ScrollPane");
    p = new Panel();
    sp = new ScrollPane();
    p.setLayout(new GridLayout(4,3));

    b1 = new Button("Button 1"); 
    b2 = new Button("Button 2"); 
    b3 = new Button("Button 3"); 
    b4 = new Button("Button 4"); 
    b5 = new Button("Button 5"); 
    b6 = new Button("Button 6"); 
    b7 = new Button("Button 7"); 
    b8 = new Button("Button 8"); 
    b9 = new Button("Button 9"); 
    b10 = new Button("Button 10"); 
    b11 = new Button("Button 11"); 
    b12 = new Button("Button 12"); 

    p.add(b1); 
    p.add(b2); 
    p.add(b3);
    p.add(b4); 
    p.add(b5); 
    p.add(b6);
    p.add(b7); 
    p.add(b8); 
    p.add(b9);
    p.add(b10); 
    p.add(b11); 
    p.add(b12);

    sp.add(p);
    f.add(sp, BorderLayout.CENTER);
    f.setSize(100,100);
    f.setVisible(true);
  }

  public static void main (String args[]) {
    SampleScrollPane sampleScrollPane = 
        new SampleScrollPane();
    sampleScrollPane.go();
  }
}
