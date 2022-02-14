public class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
        this.noise = "Meow!";
    }

    @Override
    public void greet() {
        System.out.println("Cat " + name + " says: " + makeNoise());
    }

    public static void main(String[] args) {
        Cat betty = new Cat("betty", 3);
        Cat tom = new Cat("tom", 6);
        Animal peter = new Cat("peter", 7);
        Animal benny = new Animal("benny", 8);
        betty.greet();
        tom.greet();
        peter.greet();
        benny.greet();
    }
}
