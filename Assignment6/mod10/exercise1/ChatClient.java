package exercise1;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ChatClient {
    private JTextArea textArea;
    private JTextField textField;
    private JButton btnSend;
    private JButton btnQuit;
    private JFrame frame;
    private JPanel panel;
    private JScrollPane scrollPane;

    private void launchFrame() {
        panel = new JPanel(new GridBagLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        GridBagConstraints c = new GridBagConstraints();

        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1.0;
        c.weighty = 0.8;
        c.fill = GridBagConstraints.BOTH;

        c.gridheight = 3;
        c.insets = new Insets(5, 5, 5, 5);
        panel.add(scrollPane, c);

        btnSend = new JButton("Send");
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 0;
        c.weighty = 0;
        c.gridwidth = 0;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.NORTH;
        panel.add(btnSend, c);

        btnQuit = new JButton("Quit");
        c.gridx = 1;
        c.gridy = 1;
        c.anchor = GridBagConstraints.NORTH;
        panel.add(btnQuit, c);

        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 0;
        panel.add(new JPanel(), c);

        textField = new JTextField(50);
        c = new GridBagConstraints();
        c.weightx = 1;
        c.weighty = 0.2;
        c.fill = GridBagConstraints.BOTH;
        panel.add(textField, c);



    }

    protected ChatClient() {
        frame = new JFrame("Chat Room");

        launchFrame();

        frame.add(panel);
        frame.setMinimumSize(new Dimension(800, 400));
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        ChatClient client = new ChatClient();
    }
}
