import db.Database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class DBTest {
    private static PrintWriter stdOut = new PrintWriter(System.out);
    private static BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
    private Database db;

    public DBTest() {
        try {
            db = new Database();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        try {
            new DBTest().run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void run() throws IOException {
        int choice;
        do {
            choice = getChoice();
            switch (choice) {
                case 1:
                    db.display();
                    break;
                case 2:
                    db.update();
                    break;
                case 3:
                    db.add();
                    break;
                default:
                    break;
            }

        } while (choice != 0);
        db.close();

    }


    private int getChoice() throws IOException {

        int input;

        do {
            try {
                stdOut.print("[0]  Quit\n"
                        + "[1]  Display\n"
                        + "[2]  Modify\n"
                        + "[3]  Add\n"
                        + "choice> ");
                stdOut.flush();

                input = Integer.parseInt(stdIn.readLine());

                stdOut.println();

                if (0 <= input && 3 >= input) {
                    break;
                } else {
                    stdOut.println("Invalid choice:  " + input);
                }
            } catch (NumberFormatException nfe) {
                stdOut.println(nfe);
            }
        } while (true);

        return input;
    }
}
