package exercise3.db;

import java.io.FileWriter;

public class Database {
    String fileName = "data.txt";
    FileWriter fOut;
    Record record;

    public Database() throws Exception {
        fOut = new FileWriter(fileName);

    }

    public void add() {
        //TODO
    }

    public void update() {
        //TODO
    }

    public void display() {
        //TODO
    }
}
