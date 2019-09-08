package exercise2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI implements ActionListener {
    // JButtons and a place to put them.
    private JButton[] key;
    private JButton keyequal, keyplus, keyminus;
    private JButton keyperiod, keymult, keydiv;
    private JPanel buttonArea;

    private enum ModeSwitch {
        normal, newNum
    }

    private ModeSwitch mode = ModeSwitch.normal;
    private String answerString;
    private double answerDouble;
    final static int MAXLENGTH = 12;
    private Calculator calc;

    // Where answer will be displayed.
    private JLabel answer;

    public CalculatorGUI() {

        calc = new Calculator();
        answer = new JLabel("0", SwingConstants.RIGHT);
        answerString = new String("0");
        key = new JButton[10];
        for (int i = 0; i < 10; i++) {
            key[i] = new JButton(Integer.toString(i));
            key[i].addActionListener(this);
        }

        keyequal = new JButton("=");
        keyequal.addActionListener(this);
        keyplus = new JButton("+");
        keyplus.addActionListener(this);
        keyminus = new JButton("-");
        keyminus.addActionListener(this);
        keymult = new JButton("*");
        keymult.addActionListener(this);
        keydiv = new JButton("/");
        keydiv.addActionListener(this);
        keyperiod = new JButton(".");
        keyperiod.addActionListener(this);
        buttonArea = new JPanel();
    }

    public void go() {
        buttonArea.setLayout(new GridLayout(4, 4));

        buttonArea.add(key[7]);
        buttonArea.add(key[8]);
        buttonArea.add(key[9]);
        buttonArea.add(keyplus);
        buttonArea.add(key[4]);
        buttonArea.add(key[5]);
        buttonArea.add(key[6]);
        buttonArea.add(keyminus);
        buttonArea.add(key[1]);
        buttonArea.add(key[2]);
        buttonArea.add(key[3]);
        buttonArea.add(keymult);
        buttonArea.add(key[0]);
        buttonArea.add(keyperiod);
        buttonArea.add(keyequal);
        buttonArea.add(keydiv);

        // Create a Frame
        JFrame f = new JFrame("Calculator");
        f.setSize(400, 400);

        f.add(answer, BorderLayout.NORTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(buttonArea, BorderLayout.CENTER);
        f.setVisible(true);

    }

    private void launchFrame() {
        go();
    }

    public static void main(String args[]) {
        CalculatorGUI calcGUI = new CalculatorGUI();
        calcGUI.launchFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        for (int i = 0; i < 10; i++) {
            // limit the max length of the number is MAXLENGTH
            if (mode == ModeSwitch.newNum) {
                answerString = "0";
                mode = ModeSwitch.normal;
            }
            if (key[i] == e.getSource() && answer.getText().length() < MAXLENGTH) {
                answerString += key[i].getText();

            }

        }

        if (e.getSource() == keyperiod) {
            if (!answerString.contains(".")) {
                answerString += ".";
            }
        }


        if (e.getSource() == keydiv) {
            try {
                calc.divide(answerDouble);
            } catch (ArithmeticException ee) {
                answer.setText("E");
            } finally {
                mode = ModeSwitch.newNum;
            }

        }


        if (e.getSource() == keymult) {
            calc.multiply(answerDouble);
            mode = ModeSwitch.newNum;
        }

        if (e.getSource() == keyminus) {
            calc.minus(answerDouble);
            mode = ModeSwitch.newNum;
        }

        if (e.getSource() == keyplus) {
            calc.plus(answerDouble);
            mode = ModeSwitch.newNum;
        }

        if (e.getSource() == keyequal) {
            calc.equal(answerDouble);
            mode = ModeSwitch.newNum;
            answerString = Double.toString(calc.num);
            calc.num = 0;
        }

        answerDouble = Double.parseDouble(answerString);
        answer.setText(Double.toString(answerDouble));
    }


}
