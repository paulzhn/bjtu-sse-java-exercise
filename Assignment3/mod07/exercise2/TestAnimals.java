package mod07.exercise2;

public class TestAnimals {
    public static void main(String[] args) {
        Fish d = new Fish("Fish");
        Cat c = new Cat("Cat");
        Animal a = new Fish("Animal Fish");
        Animal e = new Spider();
        Spider s = new Spider();
        Pet p = new Cat("Pet Cat");

        // Fish
        System.out.println("Test Fish: ");
        d.eat();
        d.setName("Set FishName");
        System.out.println("Name: " + d.getName());
        d.walk();
        d.play();

        // Cat
        System.out.println("\nTest Cat: ");
        c.setName("Set CatName");
        System.out.println("Cat name: " + c.getName());
        c.eat();
        c.play();
        c.walk();

        // Spider
        System.out.println("\nTest Spider: ");
        s.eat();
        s.walk();

        // Fish in Animal
        System.out.println("\nTest Fish in Animal: ");
        a.eat();
        a.walk();

        // Spider in Animal
        System.out.println("\nTest Spider in Animal: ");
        e.walk();
        e.eat();

        // Cat in Pet
        System.out.println("\nTest Cat in Pet: ");
        p.setName("Cat Pet");
        p.play();
        System.out.println("Cat in Pet Name: " + p.getName());


    }
}
