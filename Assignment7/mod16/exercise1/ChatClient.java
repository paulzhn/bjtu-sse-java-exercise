package exercise1;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.Socket;

public class ChatClient {
    private JFrame frame;
    private JPanel panel;
    private JTextArea inputBox;
    private JTextArea displayBox;
    private JScrollPane inputScroll;
    private JScrollPane displayScroll;
    private JComboBox userNameBox;
    private JButton sendBtn, exitBtn;
    private String userName;

    private JMenuBar createMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem menuItem = new JMenuItem("Exit");
        menuItem.addActionListener(e -> System.exit(0));
        menu.add(menuItem);
        menuBar.add(menu);

        menu = new JMenu("Help");
        menuItem = new JMenuItem("About");
        menuItem.addActionListener(e -> JOptionPane.showMessageDialog(null, "Created by PaulZhn\nEmail: 18301120@bjtu.edu.cn",
                "About", JOptionPane.INFORMATION_MESSAGE));
        menu.add(menuItem);
        menuBar.add(menu);

        return menuBar;


    }


    private void createGUI() {
        panel = new JPanel();
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = 0;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.insets = new Insets(0, 5, 0, 5);
        panel.add(createMenu(), c);

        displayBox = new JTextArea();
        displayBox.setWrapStyleWord(true);
        displayBox.setLineWrap(true);
        displayScroll = new JScrollPane(displayBox);
        c = new GridBagConstraints();
        c.gridwidth = 1;
        c.gridheight = 4;
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);
        panel.add(displayScroll, c);

        sendBtn = new JButton("Send");
        c.insets.set(5, 0, 0, 0);
        c.gridwidth = 0;
        c.gridheight = 1;
        c.weightx = 0;
        c.weighty = 0;
        panel.add(sendBtn, c);

        userNameBox = new JComboBox<>(new String[]{"Paul", "Crystal", "Tony"});
        userNameBox.setEditable(true);
        userNameBox.setSelectedIndex(-1);
        userNameBox.addActionListener(e -> userName = (String)((JComboBox)e.getSource()).getSelectedItem());
        panel.add(userNameBox, c);

        exitBtn = new JButton("Exit");
        panel.add(exitBtn, c);

        panel.add(new JPanel(), c);

        // Using JTextField could only input one row, which is actually impractical
        inputBox = new JTextArea(5, 0);
        c.insets.set(5, 5, 5, 5);
        c.weighty = 0.3;
        inputBox.setLineWrap(true);
        inputBox.setWrapStyleWord(true);
        inputScroll = new JScrollPane(inputBox);
        inputScroll.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // todo
                }
            }
        });
        panel.add(inputScroll, c);

    }

    private void launchFrame() {
        Socket socket = new Socket();
        frame = new JFrame("Chat Room");
        frame.add(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.pack();


        frame.setVisible(true);

    }

    public ChatClient() {
        createGUI();
        launchFrame();

    }

    public static void main(String[] args) {
        new ChatClient();
    }

}
