package client.GUI;

import javax.swing.*;
import java.awt.*;

public abstract class FuncInterfaceLayout implements InterfaceLayout {
    private JPanel panel = new JPanel(new BorderLayout());
    JButton funcBtn = new JButton();
    JButton cancelBtn = new JButton("Cancel");
    JLabel amountLbl = new JLabel("Amount: ");
    JTextField amountField = new JTextField(10);

    public FuncInterfaceLayout() {
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
        cancelBtn.addActionListener(e -> MainFrame.changePanel(MainFrame.mainInterface));

        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 0;

        panel.add(funcBtn, c);
        panel.add(cancelBtn, c);

        return panel;
    }

    @Override
    public JPanel main() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;


        c.gridwidth = 1;
        panel.add(amountLbl, c);

        c.gridwidth = 0;
        panel.add(amountField, c);

        return panel;
    }

    @Override
    public void initialize() {
        panel.add(left(), BorderLayout.WEST);
        panel.add(main(), BorderLayout.CENTER);
        panel.add(right(), BorderLayout.EAST);
    }

    @Override
    public JPanel getInterface() {
        return panel;
    }
}
