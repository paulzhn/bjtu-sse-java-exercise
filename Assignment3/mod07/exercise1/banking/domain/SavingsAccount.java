package mod07.exercise1.banking.domain;

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(double balance, double interest_rate) {
        super(balance);
        interestRate = interest_rate;
    }
}
