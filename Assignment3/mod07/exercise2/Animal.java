package mod07.exercise2;

public abstract class Animal {
    protected int legs;

    protected Animal(int legs) {
        this.legs = legs;
    }

    public void walk() {
        System.out.println("This animal walks with " + legs + " legs.");
    }

    public abstract void eat();

}
