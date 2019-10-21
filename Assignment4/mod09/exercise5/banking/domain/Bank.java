package banking.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Storage the list of customers of bank.
 *
 * @author paulzhn
 * @since 2019/9/5
 */

public class Bank {
    private List<Customer> customers;

    private static final Bank bank = new Bank();

    private Bank() {
        customers = new ArrayList<>();
    }

    public void addCustomer(String f, String l) {
        customers.add(new Customer(f, l));
    }

    public int getNumOfCustomers() {
        return customers.size();
    }

    public static Bank getBank() {
        return bank;
    }

    public Customer getCustomer(int index) {
        return customers.get(index);
    }

    public Iterator getCustomers() {
        return customers.iterator();
    }

    public void sortCustomers() {
        Collections.sort(customers);
    }
}
