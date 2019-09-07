package exercise3.db;

public class Product {
    String name;
    double quantities;

    public Product(String n, double q) {
        name = n;
        quantities = q;
    }

    public String getName() {
        return name;
    }

    public double getQuantities() {
        return quantities;
    }
}
