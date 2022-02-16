import java.util.Stack;

public class SortedStack<Item extends Comparable<Item>> {
    private Stack<Item> a;
    private Stack<Item> b;

    public SortedStack() {
        a = new Stack<>();
        b = new Stack<>();
    }

    public void push(Item t) {
        while (!a.empty() && a.peek().compareTo(t) < 0) {
            b.push(a.pop());
        }
        a.push(t);
        while (!b.empty()) {
            a.push(b.pop());
        }
    }

    public Item pop() {
        return a.pop();
    }

    public static void main(String[] args) {
        SortedStack<Integer> ss = new SortedStack<>();
        ss.push(10);
        ss.push(4);
        ss.push(8);
        ss.push(2);
        ss.push(14);
        ss.push(3);

        System.out.println(ss.pop());
        System.out.println(ss.pop());
        System.out.println(ss.pop());
        System.out.println(ss.pop());
        System.out.println(ss.pop());
        System.out.println(ss.pop());
    }
}
