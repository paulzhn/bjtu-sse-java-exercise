package mod09.exercise4.banking.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Customer implements Comparable<Customer> {
    private String firstName, lastName;
    List<Account> account;

    public Customer(String f, String l) {
        account = new ArrayList<>();
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
        return account.get(index);
    }

    public void addAccount(Account account) {
        this.account.add(account);
    }

    public void setAccount(Account account, int index) {
        this.account.set(index, account);
    }

    public int getNumOfAccounts() {
        return account.size();
    }

    public Iterator getAccounts() {
        return account.iterator();
    }

    public int compareTo(Customer o) {
        if (lastName.compareTo(o.lastName) != 0) {
            return lastName.compareTo(o.lastName);
        } else {
            return firstName.compareTo(o.firstName);
        }
    }
}
