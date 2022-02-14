/**
public class Dog extends Animal{
    public Dog(String name, int age) {
        super(name, age);
        this.noise = "Woof!";
    }

    @Override
    public void greet() {
        System.out.println("Dog " + name + " says: " + makeNoise());
    }

    public void playFetch() {
        System.out.println("Fetch, " + name +"!");
    }
}
*/
import java.util.Comparator;

public class Dog implements Comparable<Dog> {
    private String name;
    private int size;

    public Dog(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public void bark() {
        System.out.println(name + "says: bark!");
    }

    public int compareTo(Dog uddaDog) {
        return this.size - uddaDog.size;
    }
    public static class NameComparator implements Comparator<Dog> {
        public int compare(Dog a, Dog b) {
            return a.name.compareTo(b.name);
        }
    }

    public static OurComparable max(OurComparable[] items) {
        int maxDex = 0;
        for (int i = 0; i < items.length; i++) {
            int cmp = items[maxDex].compareTo(items[i]);
            if (cmp < 0) {
                maxDex = i;
            }
        }
        return items[maxDex];
    }
}