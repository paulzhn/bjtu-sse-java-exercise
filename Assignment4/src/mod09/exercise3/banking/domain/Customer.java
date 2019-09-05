package mod09.exercise3.banking.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Customer {
    Collection<String> c;
    ArrayList<String> a = new ArrayList<>(c);


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
