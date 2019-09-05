package mod08.exercise2.banking.domain;

public class OverdraftException extends Exception{
    private double deficit;

    public double getDeficit() {
        return deficit;
    }

    public OverdraftException(String message, double deficit) {
        super(message);
        this.deficit = deficit;
    }
}
