package mod06.alternate1.banking;

public class CheckingAccount extends Account {
    private SavingsAccount protectedBy = null;

    public CheckingAccount(double balance) {
        super(balance);
    }

    public CheckingAccount(double balance, SavingsAccount protect) {
        super(balance);
        protectedBy = protect;
    }

    @Override
    public boolean withdraw(double amt) {
        if(protectedBy == null) {
            if (balance - amt >= 0) {
                balance -= amt;
                return true;
            }
            return false;
        }
        else {
            if (balance - amt + protectedBy.getBalance() >= 0) {
                balance -= amt;
                if(balance < 0) {
                    protectedBy.withdraw(-balance);
                    balance = 0;
                }
                return true;
            }
            return false;
        }

    }


}
