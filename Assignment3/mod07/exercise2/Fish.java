package mod07.exercise2;

public class Fish extends Animal {
    private String name;

    public Fish(String name) {
        super(0);
        this.name = name;
    }

    public Fish() {
        this("");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void walk() {
        System.out.println("Fish have no legs and cannot walk.");
    }

    public void eat() {
        System.out.println("Fish can eat.");
    }

    public void play() {
        System.out.println("Fish can play.");
    }
}
