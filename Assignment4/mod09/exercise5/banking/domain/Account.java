package banking.domain;

/**
 * Provide methods for the basic operations of account.
 *
 * Class {@code Account} is also the superclass of {@link CheckingAccount} and
 * {@link SavingsAccount}.
 *
 * @see CheckingAccount
 * @see SavingsAccount
 * @author paulzhn
 * @since 2019/9/5
 */

public class Account {
    protected double balance;

    public Account(double init_balance) {
        balance = init_balance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amt) {
        balance += amt;
        return true;
    }

    public void withdraw(double amt) throws OverdraftException {
        if (balance - amt >= 0) {
            balance -= amt;
        } else {
            throw new OverdraftException("Insufficient funds", amt - balance);
        }
    }


}

