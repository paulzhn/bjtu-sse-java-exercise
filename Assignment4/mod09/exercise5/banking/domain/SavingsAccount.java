package banking.domain;

/**
 * Provide methods to operate the customer's savings account.
 *
 * Derived from {@link Account}.
 *
 * @see Account
 * @author paulzhn
 * @since 2019/9/5
 */

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(double balance, double interest_rate) {
        super(balance);
        interestRate = interest_rate;
    }
}
