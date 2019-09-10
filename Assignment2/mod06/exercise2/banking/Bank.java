package mod06.exercise2.banking;

public class Bank {
    private Customer[] customers;
    private int numberOfCustomers = 0;

    public Bank() {
        customers = new Customer[10];
    }
    public void addCustomer(String f, String l) {
        customers[numberOfCustomers++] = new Customer(f, l);
    }
    public int getNumOfCustomers() {
        return numberOfCustomers;
    }

    public Customer getCustomer(int index) {
        return customers[index];
    }
}
