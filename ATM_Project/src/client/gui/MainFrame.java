package GUI;

import javax.swing.*;
import java.sql.Time;

public class MainFrame {
    JFrame frame = new JFrame();

    public MainFrame() {
        frame.add(new MainInterface().getInterface());
        frame.pack();
        frame.setVisible(true);
        
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
