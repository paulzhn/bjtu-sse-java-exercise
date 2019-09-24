package exercise1;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.Socket;
import java.text.SimpleDateFormat;

public class ChatClient {
    private JFrame frame;
    private JPanel panel;
    private JTextField inputBox;
    private JTextArea displayBox;
    private JScrollPane inputScroll;
    private JScrollPane displayScroll;
    private JComboBox userNameBox;
    private JButton sendBtn, exitBtn;
    private String userName;
    private Socket socket;
    private RemoteReader reader;
    private final int PORT = 2333;
    private final String HOST = "localhost";
    private final SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

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
        displayBox.setEditable(false);
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
        sendBtn.addActionListener(e -> {
            sendText(inputBox.getText());
            inputBox.setText("");
        });
        c.insets.set(5, 0, 0, 0);
        c.gridwidth = 0;
        c.gridheight = 1;
        c.weightx = 0;
        c.weighty = 0;
        panel.add(sendBtn, c);

        userNameBox = new JComboBox<>(new String[]{"Paul", "Crystal", "Tony"});
        userName = userNameBox.getSelectedItem().toString();
        userNameBox.setSelectedIndex(0);
        userNameBox.setEditable(true);
        userNameBox.addActionListener(e -> userName = (String)((JComboBox)e.getSource()).getSelectedItem());
        panel.add(userNameBox, c);

        exitBtn = new JButton("Exit");
        exitBtn.addActionListener(e -> System.exit(0));
        panel.add(exitBtn, c);

        panel.add(new JPanel(), c);

        // Using JTextField could only input one row, which is actually impractical
        inputBox = new JTextField();
        c.insets.set(5, 5, 5, 5);
        c.weighty = 0.3;
        inputBox.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendText(inputBox.getText());
                    inputBox.setText("");
                }
            }
        });
        panel.add(inputBox, c);

    }

    private void sendText(String message) {
        if (reader != null && !"".equals(message)) {
            reader.sendMsg(userName + " " + ft.format(System.currentTimeMillis()) + "\n" + message + "\n");
        }
    }


    private void launchFrame() {
        try {
            socket = new Socket(HOST, PORT);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Connection Failed!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        frame = new JFrame("Chat Room");
        reader = new RemoteReader(socket, e -> {
            displayBox.append(e + "\n");
        });
        Thread readerThread = new Thread(reader);
        readerThread.setName("readerThread");
        readerThread.start();
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

    // todo
    //  the RemoteReader should be modified to a inner class

}
