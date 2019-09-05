package mod07.exercise1.banking.domain;

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

    public boolean withdraw(double amt) {
        if (balance - amt >= 0) {
            balance -= amt;
            return true;
        }
        return false;
    }


}

