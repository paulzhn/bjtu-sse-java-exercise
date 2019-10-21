package mod07.exercise2;

public class Cat extends Animal implements Pet {
    private String name;
    public Cat(String name) {
        super(4);
        this.name = name;
    }
    public Cat() {
        this("");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name){
        this.name = name;
    }

    @Override
    public void play() {
        System.out.println("Cats can play.");
    }

    @Override
    public void eat() {
        System.out.println("Cats can eat.");
    }



}
