package GUI;

import javax.swing.*;
import java.awt.*;

public class LoginInterface implements InterfaceLayout {
    private JPanel panel = new JPanel(new BorderLayout());

    public LoginInterface() {
        initialize();
    }

    @Override
    public JPanel left() {
        return new JPanel();
    }

    @Override
    public JPanel right() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        JButton loginBtn = new JButton("Login");
        JButton cancelBtn = new JButton("Cancel");

        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 0;
        panel.add(loginBtn, c);
        panel.add(cancelBtn, c);

        return panel;
    }

    @Override
    public JPanel main() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        JLabel usernameLbl = new JLabel("Card Number: ");
        JLabel passwordLbl = new JLabel("Password: ");
        JTextField usernameField = new JTextField(10);
        JPasswordField passwordField = new JPasswordField(10);

        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 1;
        panel.add(usernameLbl, c);

        c.gridwidth = 0;
        panel.add(usernameField, c);

        c.gridwidth = 1;
        panel.add(passwordLbl, c);

        c.gridwidth = 0;
        panel.add(passwordField, c);

        return panel;
    }

    @Override
    public void initialize() {
        panel.add(main(), BorderLayout.CENTER);
        panel.add(right(), BorderLayout.EAST);
    }

    @Override
    public JPanel getInterface() {
        return panel;
    }
}
