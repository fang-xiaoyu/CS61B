public class DLListOfInts implements ListOfInts{
    public class IntNode {
        public int item;
        public IntNode next, prev;
    }
    public IntNode sentinel;
    public int size;
    @Override
    public void plusEquals(DLListOfInts x) {
        if (x == null || this.size != x.size) {
            return;
        }
        IntNode temp = x.sentinel.next;
        for (IntNode p = sentinel.next; p != null; p = p.next) {
            p.item += temp.item;
            temp = temp.next;
        }
    }
}
