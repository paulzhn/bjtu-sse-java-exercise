package mod08.exercise2.banking.domain;

public class CheckingAccount extends Account {
    private double overdraftProtection = 0;

    public CheckingAccount(double balance) {
        super(balance);
    }

    public CheckingAccount(double balance, double protect) {
        super(balance);
        overdraftProtection = protect;
    }

    @Override
    public void withdraw(double amt) throws OverdraftException{

        if (balance - amt + overdraftProtection >= 0) {
            balance -= amt;
            if (balance < 0) {
                overdraftProtection += balance;
                balance = 0;
            }
        }
        else if(overdraftProtection == 0) {
            throw new OverdraftException("No overdraft protection", amt - balance);
        }
        else {
            throw new OverdraftException("Insufficient funds for overdraft protection", amt);
        }

    }


}
