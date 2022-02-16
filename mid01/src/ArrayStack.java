public class ArrayStack<Item> implements Stack<Item> {
    private Item[] items;
    private int size;

    public  ArrayStack() {
        items = (Item[]) new Object[8];
        size = 0;
    }

    public void resize(int capacity) {
        Item[] resizeItems = (Item[]) new Object[capacity];
        System.arraycopy(items, 0, resizeItems, 0, size);
        items = resizeItems;
    }

    public void push(Item x) {
        if (usageRatio() == 1) {
            resize(2 * items.length);
        }
        items[size] = x;
        size += 1;
    }

    public Item pop() {
        if (size == 0) {
            return null;
        }
        if (usageRatio() < 0.25 && items.length > 8) {
            resize(items.length / 2);
        }
        Item result = items[size - 1];
        size -= 1;
        items[size] = null;
        return result;
    }

    public int size() {
        return size;
    }

    private double usageRatio() {
        return ((double) size()) / items.length;
    }
}
