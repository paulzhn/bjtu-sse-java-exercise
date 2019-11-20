package GUI;

import javax.swing.*;

public class DepositInterface extends FuncInterfaceLayout {

    @Override
    public JPanel right() {
        funcBtn.setText("Deposit");
        return super.right();
    }

    @Override
    public JPanel main() {
        return super.main();
    }
}
