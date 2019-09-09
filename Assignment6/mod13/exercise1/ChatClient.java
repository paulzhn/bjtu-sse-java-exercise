package exercise1;

import jdk.nashorn.internal.scripts.JD;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class ChatClient {
    private JTextArea textArea;
    private JTextField textField;
    private JButton btnSend;
    private JButton btnQuit;
    private JFrame frame;
    private JPanel panel;
    private JScrollPane scrollPane;
    private JComboBox user;
    private String userName;

    private JMenuBar menuBar;
    private JMenu file, help;
    private JMenuItem exit, about;

    final static String ENDL = "\n";


    private void launchFrame() {
        panel = new JPanel(new GridBagLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        menuBar = new JMenuBar();
        file = new JMenu("File");
        help = new JMenu("Help");
        exit = new JMenuItem("Exit");
        about = new JMenuItem("About");
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Created by PaulZhn\nEmail: 18301120@bjtu.edu.cn",
                        "About", JOptionPane.PLAIN_MESSAGE);
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        file.add(exit);
        menuBar.add(file);
        menuBar.add(help);
        help.add(about);

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.WEST;
        panel.add(menuBar, c);

        //TODO the menuBar should be seperated to another method, and invoke setMenubar()
        // to add it, instead of add() directly.


        c = new GridBagConstraints();

        textArea = new JTextArea();
        textArea.setEditable(false);
        scrollPane = new JScrollPane(textArea);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1.0;
        c.weighty = 0.8;
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 4;
        c.insets = new Insets(5, 5, 5, 5);
        panel.add(scrollPane, c);

        btnSend = new JButton("Send");
        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 0;
        c.weighty = 0;
        c.gridwidth = 0;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.NORTH;
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendText();
            }
        });
        panel.add(btnSend, c);

        btnQuit = new JButton("Quit");
        c.gridx = 1;
        c.gridy = 3;
        c.anchor = GridBagConstraints.NORTH;
        btnQuit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(btnQuit, c);

        user = new JComboBox<>(new String[]{"Paul", "Crystal", "Tony"});
        userName = (String) user.getSelectedItem();
        user.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                userName = (String) cb.getSelectedItem();
            }
        });
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 2;
        panel.add(user, c);

        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth = 0;
        panel.add(new JPanel(), c);


        textField = new JTextField(50);
        c = new GridBagConstraints();
        c.weightx = 1;
        c.weighty = 0.2;
        c.fill = GridBagConstraints.BOTH;
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendText();
                }
            }

        });
        panel.add(textField, c);


    }

    private ChatClient() {
        launchFrame();

        frame = new JFrame("Chat Room");
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosed(e);
                System.exit(0);
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.setMinimumSize(new Dimension(800, 400));
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ChatClient();
    }

    private void sendText() {
        textArea.append(new Date().toString() + " " + userName + ENDL);
        textArea.append(textField.getText() + ENDL + ENDL);
        textArea.setCaretPosition(textArea.getDocument().getLength());
        textField.setText("");
    }


}
