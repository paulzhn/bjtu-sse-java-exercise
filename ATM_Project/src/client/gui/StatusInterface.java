package GUI;

import javax.swing.*;
import java.awt.*;

public class StatusInterface implements InterfaceLayout {
    private JPanel panel = new JPanel(new BorderLayout());
    private JLabel statusLbl = new JLabel();


    public static final int WITHDRAW_SUCCESSFUL = 1;
    public static final int TRANSFER_SUCCESSFUL = 2;
    public static final int DEPOSIT_SUCCESSFUL = 3;
    public static final int MODIFY_PWD_SUCCESSFUL = 4;
    public static final int WITHDRAW_FAILED = 5;
    public static final int TRANSFER_FAILED = 6;
    public static final int DEPOSIT_FAILED = 7;
    public static final int MODIFY_PWD_FAILED = 8;

    public static final int BALANCE_INSUFFICIENT = 9;
    public static final int TWO_TIME_PWD_NOT_MATCH = 10;
    public static final int CARD_NUMBER_INCORRECT = 11;



    @Override
    public JPanel left() {
        return new JPanel();
    }

    @Override
    public JPanel right() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        JButton cancelBtn = new JButton("Cancel");

        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 0;

        panel.add(cancelBtn, c);

        return panel;
    }

    @Override
    public JPanel main() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        c.gridwidth = 0;
        panel.add(statusLbl, c);

        return panel;
    }

    @Override
    public void initialize() {
        panel.add(statusLbl, BorderLayout.CENTER);
    }

    @Override
    public JPanel getInterface() {
        return panel;
    }
}
