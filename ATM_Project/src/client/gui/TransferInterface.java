package GUI;

import javax.swing.*;
import java.awt.*;

public class TransferInterface extends FuncInterfaceLayout {
    @Override
    public JPanel right() {
        funcBtn.setText("Deposit");
        return super.right();
    }

}
