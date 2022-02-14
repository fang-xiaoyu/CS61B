/**
public class TestAnimals {
    public static void main(String[] args) {
        Animal a = new Animal("Pluto", 10);
        Cat c = new Cat("Garfield", 6);
        Dog d = new Dog("Fido", 4);

        a = c;
        //((Cat) a).greet();
        a.greet();
        a = new Dog("Spot", 10);
        a.greet();
        d =(Dog) a;
    }
}
*/