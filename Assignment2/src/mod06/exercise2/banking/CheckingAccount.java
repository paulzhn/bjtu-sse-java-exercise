package mod06.exercise2.banking;

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
    public boolean withdraw(double amt) {

        if (balance - amt + overdraftProtection>= 0) {
            balance -= amt;
            if(balance < 0) {
                overdraftProtection += balance;
                balance = 0;
            }
            return true;
        }
        return false;
    }


}
