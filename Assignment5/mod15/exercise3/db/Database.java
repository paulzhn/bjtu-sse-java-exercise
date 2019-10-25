package db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


/**
 * Storage data with class {@link RandomAccessFile}.
 *
 * @author paulzhn
 * @since 2019/10/21
 */
public class Database {
    private String fileName = "data.txt";
    private RandomAccessFile raf;
    /**
     * To make sure file pointer move correctly, every entry is set to be 32 bytes.
     */
    private final int LENGTH_OF_ENTRY = 32;
    private BufferedReader stdIn;

    public Database(BufferedReader stdIn) throws IOException {
        this.stdIn = stdIn;
        raf = new RandomAccessFile(fileName, "rw");
    }

    public void add() throws IOException {
        String name;
        int quantity;

        System.out.println("Please input the name: ");
        name = stdIn.readLine();
        System.out.println("Please input the quantity: ");
        quantity = Integer.parseInt(stdIn.readLine());

        add(name, quantity, raf.length());
    }

    /**
     * Add a new entry to the database. Also could be used to modify an entry.
     * @param name the name of the entry
     * @param quantity the quantity of the entry
     * @param pos the start position of the entry
     * @throws IOException when the access to the database file is invalid
     */
    private void add(String name, int quantity, long pos) throws IOException {
        if (name.contains(",")) {
            System.out.println("Illegal name!");
            return;
        }

        if (!judgeLegal(name, quantity)) {
            System.out.println("The entry's length is too long!");
            return;
        }

        raf.seek(pos);
        long before = raf.getFilePointer();
        raf.writeBytes(name + "," + quantity);
        long now = raf.getFilePointer();
        // If length of the entry is less than LENGTH_OF_ENTRY - 1 (minus for the endl), fill it with whitespace.
        if (now - before < LENGTH_OF_ENTRY - 1) {
            for (int i = 0; i < LENGTH_OF_ENTRY - 1 - (now - before); i++) {
                raf.write(' ');
            }
        }
        raf.write('\n');
    }

    public void update() throws IOException {
        System.out.println("Please input the name of the entry to modify: ");
        update(stdIn.readLine());
    }

    /**
     * Update an entry.
     * @param name
     * @throws IOException
     */
    private void update(String name) throws IOException {
        ArrayList<String> result = find(name);


        if (result == null) {
            System.out.println("Entry not found!");
            return;
        }
        long pos = Long.parseLong(result.get(2));

        while (true) {
            boolean ok = true;

            String modifiedName;
            String tmp;
            int modifiedQuantity;
            
            System.out.println("Please input the modified name, enter for not modifying: ");
            modifiedName = stdIn.readLine();
            if (modifiedName.isEmpty()) {
                modifiedName = name;
            }
            System.out.println("Please input the modified quantity, enter for not modifying: ");
            tmp = stdIn.readLine();
            for (int i = 0; i < tmp.length(); i++) {
                if (tmp.charAt(i) < '0' || tmp.charAt(i) > '9') {
                    ok = false;
                    break;
                }
            }
            if (tmp.isEmpty()) {
                // remove the whitespace
                tmp = result.get(1).split(" ")[0];
            }
            if (ok) {
                modifiedQuantity = Integer.parseInt(tmp);
                if (judgeLegal(name, modifiedQuantity)) {
                    add(modifiedName, modifiedQuantity, pos);
                    return;
                }
            }
            System.out.println("Wrong input. Try again.");


        }

    }

    public void display() throws IOException {
        System.out.println("Please input the name: ");
        display(stdIn.readLine());
    }

    /**
     * Display the specific entry.
     * @param name the entry to display
     * @throws IOException
     */
    private void display(String name) throws IOException {
        ArrayList<String> result;

        if ((result = find(name)) == null) {
            System.out.println("Entry not found!");
            return;
        }

        System.out.println("Name: " + name);
        System.out.println("Quantity: " + result.get(1));
    }

    private ArrayList<String> find(String name) throws IOException {
        raf.seek(0);
        while (raf.getFilePointer() != raf.length()) {
            ArrayList<String> result = new ArrayList<>(Arrays.asList(raf.readLine().split(",")));

            if (result.get(0).equals(name)) {
                result.add(Long.toString(raf.getFilePointer() - LENGTH_OF_ENTRY));
                return result;
            }
        }
        return null;
    }


    /**
     * To judge if the entry is legal.
     * @param name
     * @param quantity
     * @return the result of judgement, true for legal.
     */
    private boolean judgeLegal(String name, int quantity) {
        if ((name + quantity + ",").length() + 1 <= LENGTH_OF_ENTRY) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Close the database file.
     * @throws IOException
     */
    public void close() throws IOException {
        raf.close();
    }
}
