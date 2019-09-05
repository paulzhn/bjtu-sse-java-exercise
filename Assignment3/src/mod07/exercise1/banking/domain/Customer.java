package mod07.exercise1.banking.domain;

public class Customer {
    private String firstName, lastName;
    Account account[] = new Account[5];
    private int numOfAccounts = 0;

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

    public Account getAccount(int index) {
        return account[index];
    }

    public void addAccount(Account account) {
        this.account[numOfAccounts++] = account;
    }

    public void setAccount(Account account, int index) {
        this.account[index] = account;
    }

    public int getNumOfAccounts() {
        return numOfAccounts;
    }
}
