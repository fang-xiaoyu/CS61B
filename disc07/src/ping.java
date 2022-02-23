import java.util.Set;
import java.util.HashSet;
import java.util.TreeMap;
public class ping {
    public static int[] union(int[] a, int[] b) {
        HashSet<Integer> set = new HashSet<>();
        for (int s1 : a) {
            set.add(s1);
        }
        for (int s2: b) {
            set.add(s2);
        }

        int[] c = new int[set.size()];
        int index = 0;
        for (int num: set) {
            c[index] = num;
            index += 1;
        }
        return c;
    }

    public static int[] intersect(int[] a, int[] b) {
        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();
        for (int s1 : a) {
            setA.add(s1);
        }
        for (int s2: b) {
            setB.add(s2);
        }

        int[] c = new int[setA.size()];
        int index = 0;
        for (int num: setA) {
            if (setB.contains(num)) {
                c[index] = num;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] b = {3, 4, 5, 6};
        int[] c = union(a, b);
        System.out.println(c);
        TreeMap<String, Integer> map = new TreeMap<>();
        map.getOrDefault(a, 1);
    }
}
