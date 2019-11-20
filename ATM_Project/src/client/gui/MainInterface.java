package GUI;

import javax.swing.*;
import java.awt.*;

public class MainInterface implements InterfaceLayout {
    public MainInterface() {
        initialize();
    }

    private JPanel panel = new JPanel(new BorderLayout());
    @Override
    public JPanel left() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        JButton depositBtn = new JButton("Deposit");
        JButton transferBtn = new JButton("Transfer");
        JButton modifyPwdBtn = new JButton("Modify Password");

        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 0;
        panel.add(depositBtn, c);
        panel.add(transferBtn, c);
        panel.add(modifyPwdBtn, c);

        return panel;
    }

    @Override
    public JPanel right() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        JButton queryBtn = new JButton("Query Balance");
        JButton withdrawBtn = new JButton("Withdraw");
        JButton exitBtn = new JButton("Exit");

        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 0;
        panel.add(queryBtn, c);
        panel.add(withdrawBtn, c);
        panel.add(exitBtn, c);

        return panel;
    }

    @Override
    public JPanel main() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        return panel;
    }

    @Override
    public void initialize() {
        panel.add(left(), BorderLayout.WEST);
        panel.add(right(), BorderLayout.EAST);
        panel.add(main(), BorderLayout.CENTER);

    }

    @Override
    public JPanel getInterface() {
        return panel;
    }
}
