package mod09.exercise5.banking.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Storage the details of each customer.
 *
 * @author paulzhn
 * @since 2019/9/5
 */

public class Customer implements Comparable<Customer> {
    private String firstName, lastName;

    /**
     * The list of accounts belonging to one customer.
     */
    List<Account> account;

    /**
     * Initialize the account list and set the customer's name.
     *
     * @param f first name of the customer
     * @param l last name of the customer
     */
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

    /**
     * Add an account for the customer.
     * @param account the account to be added
     */
    public void addAccount(Account account) {
        this.account.add(account);
    }

    /**
     * Set the account by the specific account.
     * @param account the account to be set into
     * @param index the index of which account should be set
     */
    public void setAccount(Account account, int index) {
        this.account.set(index, account);
    }

    /**
     * @return the number of account belonging this customer.
     */

    public int getNumOfAccounts() {
        return account.size();
    }

    /**
     * @return an iterator to the list {@code account}.
     */
    public Iterator getAccounts() {
        return account.iterator();
    }

    /**
     * Compare two customers in a lexigraphical order with the last name taking precedence
     * over the first name.For example, "Joe Smith" should come before "Samuel Smith".
     *
     * @param o the {@code Customer} object to be compared
     * @return the difference between the first not-equal-to letter. If equal, return 0;
     * if the param is smaller, return a positive number; conversely return a negative number.
     */

    public int compareTo(Customer o) {
        if (lastName.compareTo(o.lastName) != 0) {
            return lastName.compareTo(o.lastName);
        } else {
            return firstName.compareTo(o.firstName);
        }
    }
}
