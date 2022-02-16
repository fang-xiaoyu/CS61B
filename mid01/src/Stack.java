public interface Stack<Item> {
    void push(Item x);
    Item pop();
    int size();
    public default void purge(Item x) {
        if (this.size() == 0) {
            return;
        }
        Item top = this.pop();
        this.purge(x);
        if (!x.equals(top)) {
            this.push(top);
        }
    }
}
