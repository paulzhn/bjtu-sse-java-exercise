package server;

import exception.AccountNotFoundException;
import exception.InsufficientBalanceException;
import exception.WrongNumberException;

import java.util.ArrayList;

/**
 * The {@code server.Bank} storages all accounts and provides a series of methods to deploy operations.
 *
 * @author paulzhn
 * @since 2019/10/30
 * @// TODO: 2019/10/30 the amount passed into the method should be clear
 */
public class Bank {
    private static final Bank BANK = InstanceHolder.getInstance();
    private ArrayList<Account> accountList = new ArrayList<>();
    private String adminPassword = "IAmAdmin";

    private Bank() {
    }

    public void addAccount(Account account) {
        BANK.accountList.add(account);
    }

    public void deleteAccount(int cardNumber) throws AccountNotFoundException {
        Account account = getAccount(cardNumber);
        if (account != null) {
            BANK.accountList.remove(account);
        }
        throw new AccountNotFoundException();
    }

    public Account getAccount(int cardNumber) throws AccountNotFoundException {
        Account account = null;
        for (Account acc : BANK.accountList) {
            if (acc.getCardNumber() == cardNumber) {
                account = acc;
                break;
            }
        }
        if (account != null) {
            return account;
        }
        throw new AccountNotFoundException();
    }

    public double query(int cardNumber) throws AccountNotFoundException {
        Account account = getAccount(cardNumber);
        if (account != null) {
            return account.getBalance();
        }
        throw new AccountNotFoundException();

    }

    public void deposit(int cardNumber, double amount) throws AccountNotFoundException, WrongNumberException {
        Account account = getAccount(cardNumber);

        if (amount < 0) {
            throw new WrongNumberException("The amount should not less than 0.");
        }

        account.setBalance(account.getBalance() + amount);

    }

    public void withdraw(int cardNumber, double amount) throws AccountNotFoundException, WrongNumberException,
            InsufficientBalanceException {
        Account account = getAccount(cardNumber);

        if (amount < 0) {
            throw new WrongNumberException("The amount should not less than 0.");
        }

        if (Double.compare(account.getBalance(), amount) >= 0) {
            account.setBalance(account.getBalance() - amount);
            return;
        }

        throw new InsufficientBalanceException();
    }

    public void transfer(int fromNumber, int toNumber, double amount) throws AccountNotFoundException,
            WrongNumberException, InsufficientBalanceException {
        getAccount(toNumber);
        withdraw(fromNumber, amount);
        deposit(toNumber, amount);
    }


    public void modifyPwd(int cardNumber, int newPassword) throws AccountNotFoundException{
        Account account = getAccount(cardNumber);
        account.setPassword(newPassword);
    }

    public String getAdminPassword() {
        return BANK.adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        BANK.adminPassword = adminPassword;
    }

    private static class InstanceHolder {
        private static final Bank BANK = new Bank();

        private static Bank getInstance() {
            return BANK;
        }
    }

    public static Bank getInstance() {
        return BANK;
    }
}
