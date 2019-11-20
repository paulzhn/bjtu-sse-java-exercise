package GUI;

import javax.swing.*;
import java.awt.*;

public class ModifyPwdInterface extends FuncInterfaceLayout {

    @Override
    public JPanel right() {
        funcBtn.setText("Confirm");
        return super.right();
    }

    @Override
    public JPanel main() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        JLabel pwdLbl = new JLabel("Input new password: ");
        JLabel rePwdLbl = new JLabel("Re-input new password: ");
        JPasswordField pwdField = new JPasswordField(10);
        JPasswordField rePwdField = new JPasswordField(10);

        c.gridwidth = 1;
        panel.add(pwdLbl, c);

        c.gridwidth = 0;
        panel.add(pwdField, c);

        c.gridwidth = 1;
        panel.add(rePwdLbl, c);

        c.gridwidth = 0;
        panel.add(rePwdField, c);

        return panel;
    }
}
