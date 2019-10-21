package banking.reports;

import banking.domain.*;

import java.text.NumberFormat;
import java.util.Iterator;
//TODO
// Why should it be modified to use ArrayList?

public class CustomerReport_opt {

    public void generateReport() {
        NumberFormat currency_format = NumberFormat.getCurrencyInstance();

        Bank bank = Bank.getBank(); /*** STEP 1: RETRIEVE BANK SINGLETON OBJECT HERE ***/

        Customer customer;
        Iterator customerIt = bank.getCustomers();

        System.out.println("\t\t\tCUSTOMERS REPORT");
        System.out.println("\t\t\t================");

        while(customerIt.hasNext()) {
            customer = (Customer)customerIt.next();

            Iterator accountIt = customer.getAccounts();

            System.out.println();
            System.out.println("Customer: "
                    + customer.getLastName() + ", "
                    + customer.getFirstName());

            while(accountIt.hasNext()) {
                Account account = (Account)accountIt.next();
                String account_type = "";

                // Determine the account type
                if (account instanceof SavingsAccount) {
                    account_type = "Savings Account";
                } else if (account instanceof CheckingAccount) {
                    account_type = "Checking Account";
                } else {
                    account_type = "Unknown Account Type";
                }

                // Print the current balance of the account
                System.out.println("    " + account_type + ": current balance is "
                        + currency_format.format(account.getBalance()));
            }
        }
    }

}
