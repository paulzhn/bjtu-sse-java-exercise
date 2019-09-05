import java.awt.*;
import java.awt.event.*;

public class TestPrinting {

  private Frame frame;
  private TextArea output;
  private TextField input;

  public TestPrinting() {
    frame = new Frame("Chat Room");
    output = new TextArea(10,50);
    input = new TextField(50);
  }

  public void launchFrame() {
    Button button;

    frame.setLayout(new BorderLayout());

    frame.add(output,BorderLayout.WEST);
    frame.add(input,BorderLayout.SOUTH);

    Panel p1 = new Panel(); 

    // Add Send button
    button = new Button("Send");
    button.addActionListener(new SendHandler());
    p1.add(button);

    // Add Print button
    button = new Button("Print");
    button.addActionListener(new PrintHandler());
    p1.add(button);

    // Add Quit button
    button = new Button("Quit");
    // Use an anonymous inner class for variety.
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
	System.exit(0);
      }
    });
    p1.add(button);

    frame.add(p1,BorderLayout.CENTER);

    // Attach listener to the appropriate components
    frame.addWindowListener(new CloseHandler());
    input.addActionListener(new InputHandler());

    frame.setSize(440,210);
    frame.setVisible(true);
  }

  private void copyText() {
    String text = input.getText();
    output.setText(output.getText()+text+"\n");
    input.setText("");
  }

  private class SendHandler implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      copyText();
    }
  }

  private class PrintHandler implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      Toolkit toolkit = frame.getToolkit();
      PrintJob job = toolkit.getPrintJob(frame, "Print the Chat Room", null);
      Graphics g = job.getGraphics();

      frame.print(g);
      g.dispose();
      job.end();
    }
  }

  private class CloseHandler extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
      System.exit(0);
    }
  }
    
  private class InputHandler implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      copyText(); 
    }
  }

  public static void main(String[] args) {
    TestPrinting c = new TestPrinting();
    c.launchFrame();
  }
}
