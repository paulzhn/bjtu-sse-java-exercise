package exercise3.db;

public class Record {
    String name;
    int quantities;

    public Record(String n, int q) {
        name = n;
        quantities = q;
    }

    public String getName() {
        return name;
    }

    public int getQuantities() {
        return quantities;
    }
}
