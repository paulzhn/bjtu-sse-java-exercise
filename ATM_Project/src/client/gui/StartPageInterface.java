package GUI;

import javax.swing.*;
import java.awt.*;

public class StartPageInterface implements InterfaceLayout {
    private JPanel panel = new JPanel();

    public StartPageInterface() {
        initialize();
    }

    @Override
    public JPanel getInterface() {
        return panel;
    }

    @Override
    public JPanel left() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        JButton loginBtn = new JButton("Login");

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0;
        c.gridwidth = 0;
        panel.add(loginBtn, c);

        return panel;
    }

    @Override
    public JPanel right() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        JButton loginBtn = new JButton("Admin Login");

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0;
        c.gridwidth = 0;
        panel.add(loginBtn, c);

        return panel;
    }

    @Override
    public JPanel main() {
        return null;
    }

    @Override
    public void initialize() {
        panel.setLayout(new BorderLayout());
        panel.add(left(), BorderLayout.WEST);
        panel.add(right(), BorderLayout.EAST);
        //panel.add(main(), BorderLayout.CENTER);
    }
}
