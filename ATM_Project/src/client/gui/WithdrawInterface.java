package GUI;

import javax.swing.*;

public class WithdrawInterface extends FuncInterfaceLayout {
    @Override
    public JPanel right() {
        funcBtn.setText("Withdraw");
        return super.right();
    }
}
