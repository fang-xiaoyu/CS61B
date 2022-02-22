public class BadIntegerStack {
    public class Node {
        public Integer value;
        public Node prev;

        public Node(Integer v, Node p) {
            value = v;
            prev = p;
            }
    }
    public Node top;

    public boolean isEmpty() {
        return top == null;
    }

    public void push(Integer num) {
        top = new Node(num, top);
    }

    public Integer pop() {
        Integer ans = top.value;
        top = top.prev;
        return ans;
    }

    public Integer peek() {
        return top.value;
    }

    public static void main(String[] args) {
        BadIntegerStack bs = new BadIntegerStack();
        bs.push(1);
        bs.top.prev = bs.top;
    }




}
