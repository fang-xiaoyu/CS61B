public class LinkedListDeque<T> {
    public class StaffNode {
        public StaffNode prev;
        public T item;
        public StaffNode next;

        public StaffNode(StaffNode p, T x, StaffNode n) {
            prev = p;
            item = x;
            next = n;
        }
    }

    public StaffNode first;
    public StaffNode last;
    public StaffNode sentinel;
    public int size;

    public LinkedListDeque() {
        sentinel = new StaffNode(null, null, null);
        first = sentinel;
        last = sentinel;
        size = 0;
    }

    public void addFirst(T x) {

    }
}
