package server;

import client.function.ToolKit;
import exception.AccountNotFoundException;
import exception.InsufficientBalanceException;
import exception.WrongNumberException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * The server of the ATM system.
 *
 * @author paulzhn
 * @since 2019/10/30
 */
public class Server {
    private ServerSocket serverSocket;
    private static final int PORT = 2333;

    public Server() {
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listen() {
        Socket socket;
        while (true) {
            try {
                socket = serverSocket.accept();
                new Thread(new ServerOperation(socket)).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class ServerOperation implements Runnable {
        private Socket socket;
        private BufferedReader reader;
        private PrintStream printer;
        private Bank bank = Bank.getInstance();

        public ServerOperation(Socket socket) {
            this.socket = socket;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                printer = new PrintStream(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void listen() {
            String temp;
            while (socket.isConnected()) {
                try {
                    temp = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
                String[] temp2 = temp.split(" ");
                int cardNumber = Integer.parseInt(temp2[0]);
                int password = Integer.parseInt(temp2[1]);
                char operation = temp2[2].toCharArray()[0];
                double amount = Double.parseDouble(temp2[3]);


                System.out.println(operation);
                try {
                    switch (operation) {
                        case 'Q':
                            printer.println(ToolKit.OPERATION_SUCCESSFUL + " " + bank.query(cardNumber));
                            break;
                        case 'D':
                            bank.deposit(cardNumber, amount);
                            printer.println(ToolKit.OPERATION_SUCCESSFUL);
                            break;
                        case 'W':
                            bank.withdraw(cardNumber, amount);
                            printer.println(ToolKit.OPERATION_SUCCESSFUL);
                            break;
                        case 'T':
                            int targetNumber = Integer.parseInt(temp2[4]);
                            bank.transfer(cardNumber, targetNumber, amount);
                            printer.println(ToolKit.OPERATION_SUCCESSFUL);
                            break;
                        case 'L':
                            if (checkPassword(cardNumber, password)) {
                                printer.println(ToolKit.OPERATION_SUCCESSFUL);
                            } else {
                                printer.println(ToolKit.WRONG_PASSWD_OR_ACCOUNT);
                            }
                            break;
                        case 'M':
                            int newPassword = Integer.parseInt(reader.readLine());
                            bank.modifyPwd(cardNumber, newPassword);
                            printer.println(ToolKit.OPERATION_SUCCESSFUL);
                            break;
                        default:
                            printer.println(ToolKit.UNKNOWN_ERROR);
                            break;
                    }
                } catch (AccountNotFoundException e) {
                    printer.println(ToolKit.ACCOUNT_NOT_FOUND);
                } catch (WrongNumberException e) {
                    printer.println(ToolKit.WRONG_AMOUNT);
                } catch (InsufficientBalanceException e) {
                    printer.println(ToolKit.INSUFFICIENT_BALANCE);
                } catch (IOException e) {
                    printer.println(ToolKit.UNKNOWN_ERROR);
                }

            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private boolean checkPassword(int cardNumber, int password) throws AccountNotFoundException {
            return Bank.getInstance().getAccount(cardNumber).getPassword() == password;
        }

        @Override
        public void run() {
            bank.addAccount(new Account(123456));
            listen();
        }
    }

    public static void main(String[] args) {
        new Server().listen();
    }


}
