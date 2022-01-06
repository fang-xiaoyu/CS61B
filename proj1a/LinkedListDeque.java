public class LinkedListDeque<T> {
    public class StaffNode {
        public StaffNode prev;
        public T item;
        public StaffNode next;

        private StaffNode(StaffNode p, T x, StaffNode n) {
            prev = p;
            item = x;
            next = n;
        }
    }

    private StaffNode first;
    private StaffNode last;
    private StaffNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new StaffNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        first = sentinel;
        last = sentinel;
        size = 0;
    }

    public void addFirst(T x) {
        StaffNode temp = first;
        first = new StaffNode(null, x, null);
        sentinel.next = first;
        first.prev = sentinel;
        first.next = temp;
        temp.prev = first;
        if (last == sentinel) {
            last = first;
        }
        size += 1;
    }

    public void addLast(T x) {
        StaffNode temp = last;
        last = new StaffNode(null, x, null);
        sentinel.prev = last;
        last.next = sentinel;
        last.prev = temp;
        temp.next = last;
        if (first == sentinel) {
            first = last;
        }
        size += 1;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        StaffNode temp = first;
        while (temp.next != sentinel) {
            System.out.print(temp.item + " ");
            temp = temp.next;
        }
        System.out.print(temp.item);
    }
    /**
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        StaffNode temp = first;
        first = temp.next;
        sentinel.next = first;
        first.prev = sentinel;
        temp.prev = null;
        temp.next = null;
        size -= 1;
        return temp.item;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        StaffNode temp = last;
        last = temp.prev;
        sentinel.prev = last;
        last.next = sentinel;
        temp.prev = null;
        temp.next = null;
        size -= 1;
        return temp.item;
    }
    */
    public T removeFirst() {
        if(size==0){
            return null;
        }
        T res = first.item;
        sentinel.next = first.next;
        first.next.prev = sentinel;
        first = first.next;
        if(first == sentinel) {
            last = sentinel;
        }
        size-=1;
        return res;
    }

    public T removeLast() {
        if(size==0){
            return null;
        }
        T res = last.item;
        last.prev.next = last.next;
        last.next.prev = last.prev;
        last = last.prev;
        if(last == sentinel) {
            first = sentinel;
        }
        size-=1;
        return res;
    }
    
    /**
    public T get(int index) {
        if (size < index) {
            return null;
        }
        StaffNode temp = first;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.item;
    }

    public LinkedListDeque(LinkedListDeque D) {
        this();
        for (int i = 0; i < D.size; i++) {
            T item = (T) D.get(i);
            addLast(item);
        }
    }

    public T getRecursive(int index) {
        if (index == 0) {
            return first.item;
        }
        LinkedListDeque temp = new LinkedListDeque(this);
        temp.removeFirst();
        return (T) temp.getRecursive(index-1);
    }
     */
    public T get(int index) {
        if(index<0 || index>=size) {
            return null;
        }else if(index==0) {
            return first.item;
        }else if(index==size-1) {
            return last.item;
        }
        StaffNode p=first;
        for(int i=0; i<index; i+=1) {
            p=p.next;
        }
        T res=p.item;
        return res;
    }

    public T getRecursive(int index) {
        if(index<0 || index>=size) {
            return null;
        }
        return getRecursiveHelper(index, first);
    }

    private T getRecursiveHelper(int index, StaffNode n){
        if(index==0){
            return n.item;
        }
        return getRecursiveHelper(index-1, n.next);
    }
}
