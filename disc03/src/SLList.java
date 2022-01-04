public class SLList {
    private class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }

    private IntNode first;

    public SLList(int x) {
        first = new IntNode(x, null);
    }

    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    public void insert(int item, int position) {
        if (position == 0) {
            first = new IntNode(item, first);
            return;
        }
        IntNode temp = first;
        while (position != 0) {
            if (temp.next == null) {
                temp.next = new IntNode(item, null);
            } else {
                temp = temp.next;
                position -= 1;
            }
        }
    }

    public void reverse() {
        IntNode reversed = null;
        IntNode temp = first;
        while (temp != null) {
            IntNode remainder = temp.next;
            temp.next = reversed;
            reversed = temp;
            temp = remainder;
        }
        first = reversed;
    }

/**    public IntNode reverseRecursive(IntNode next) {
        first = helper(first);
        return next;
    }

    private IntNode helper(IntNode front) {
        if (front == null || front.next == null) {
            return front;
        } else {
            IntNode reversed = reverseRecursive(front.next);
            front.next.next = front;
            front.next = null;
            return reversed;
        }

    }*/
}
