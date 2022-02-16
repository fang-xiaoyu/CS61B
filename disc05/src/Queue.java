import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Queue<Item> {
    private Stack<Item> a;
    private Stack<Item> b;

    public Queue() {
        a = new Stack<>();
        b = new Stack<>();
    }

    public void push(Item t) {
        while (!a.empty()) {
            b.push(a.pop());
        }
        a.push(t);
        while (!b.empty()) {
            a.push(b.pop());
        }
    }

    public static void main(String[] args) {
        Queue<String> S = new Queue<>();
        S.push("a");
        S.push("b");
        S.push("c");
    }
}
