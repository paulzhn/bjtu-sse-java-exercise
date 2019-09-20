package mod09.exercise3.banking.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
}