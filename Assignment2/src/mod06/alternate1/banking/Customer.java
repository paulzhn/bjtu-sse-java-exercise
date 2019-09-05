package mod06.alternate1.banking;

public class Customer {
    private String firstName, lastName;
    private SavingsAccount savingsAccount = null;
    private CheckingAccount checkingAccount = null;
    public Customer(String f, String l) {
        firstName = f;
        lastName = l;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public CheckingAccount getChecking() {
        return checkingAccount;
    }

    public SavingsAccount getSavings() {
        return savingsAccount;
    }

    public void setChecking(CheckingAccount checkingAccount) {
        this.checkingAccount = checkingAccount;
    }

    public void setSavings(SavingsAccount savingsAccount) {
        this.savingsAccount = savingsAccount;
    }
}
