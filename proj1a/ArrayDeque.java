public class ArrayDeque<T> {
    public T[] items;
    public int size;
    public int nextFirst;
    public int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    private T[] addSize() {
        T[] result = (T[]) new Object[size + 1];
        System.arraycopy(items, nextFirst + 1, result, nextFirst + 1, size - nextFirst);
        return result;
    }

    public T[] reduceSize() {
        T[] result = (T[]) new Object[items.length / 2];
        System.arraycopy(items, 0, result, 0, size);
        return result;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            items = addSize();
        }

    }

    public void addLast(T item) {
        if (size == items.length) {
            items = addSize();
        }
        items[size + 1] = item;
        size += 1;
        nextLast += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[i] + " ");
        }
    }

    public T removeFirst() {
        T result = items[0];

        size -= 1;
        if (items.length >= 16 && size / items.length < 0.25) {
            items = reduceSize();
        }
        return result;
    }

    public T removeLast() {
        T result = items[size - 1];
        size -= 1;
        if (items.length >= 16 && size / items.length < 0.25) {
            items = reduceSize();
        }
        return result;
    }

    public T get(int index) {
        return items[index];
    }
}
