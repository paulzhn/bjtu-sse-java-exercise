package mod07.exercise1.banking.domain;

public class Bank {
    private Customer[] customers;
    private int numberOfCustomers = 0;
    private static final Bank bank = new Bank();

    private Bank() {
        customers = new Customer[10];
    }

    public void addCustomer(String f, String l) {
        customers[numberOfCustomers++] = new Customer(f, l);
    }

    public int getNumOfCustomers() {
        return numberOfCustomers;
    }

    public static Bank getBank() {
        return bank;
    }

    public Customer getCustomer(int index) {
        return customers[index];
    }
}
