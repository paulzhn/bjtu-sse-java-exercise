package server;

/**
 * The {@code server.Account} class storage the data of each card.
 *
 * @author paulzhn
 * @since 2019/10/30
 */
public class Account {
    private int cardNumber;
    private int password = 123456;
    private volatile double balance = 0.0;

    public Account(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Account() {

    }

    public int getPassword() {
        return password;
    }

    public synchronized void setPassword(int password) {
        this.password = password;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public double getBalance() {
        return balance;
    }

    public synchronized void setBalance(double balance) {
        this.balance = balance;
    }
}
