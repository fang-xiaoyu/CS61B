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

    private T[] addHelper() {
        T[] result = (T[]) new Object[size + 1];
        System.arraycopy(items, 0, result, 0, nextLast);
        System.arraycopy(items, nextLast, result, nextLast + 1, size - nextLast);
        return result;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            items = addHelper();
            nextFirst += 1;
        }
        items[nextFirst] = item;
        size += 1;
        if (nextFirst == 0) {
            nextFirst = items.length - 1;
        } else {
            nextFirst -= 1;
        }
    }

    public void addLast(T item) {
        if (size == items.length) {
            items = addHelper();
            nextFirst += 1;
        }
        items[nextLast] = item;
        size += 1;
        if (nextLast == items.length - 1) {
            nextLast = 0;
        } else {
            nextLast += 1;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if (nextLast > nextFirst + 1) {
            for (int i = nextFirst + 1; i < nextLast; i++) {
                System.out.print(items[i] + " ");
            }
        } else if (size == 0) {
            System.out.print("");
        } else {
            for (int i = nextFirst + 1; i < items.length; i++) {
                System.out.print(items[i] + " ");
            }
            for (int j = 0; j < nextLast; j++) {
                System.out.print(items[j] + " ");
            }
        }
        System.out.println("");
    }

    public T[] reduceSize() {
        int newLength = items.length / 2;
        T[] result = (T[]) new Object[newLength];
        if (nextFirst < nextLast) {
            System.arraycopy(items, nextFirst + 1, result, 1, size);
        } else {
            System.arraycopy(items, nextFirst + 1, result, 1, items.length - nextFirst);
            System.arraycopy(items, 0, result, 1 + items.length - nextFirst, nextLast);
        }
        nextFirst = 0;
        nextLast = size + 1;
        return result;
    }

    public T removeFirst() {
        size -= 1;
        T result = null;
        if (nextFirst == items.length - 1) {
            result = items[0];
            nextFirst = 0;
        } else {
            result = items[nextFirst + 1];
            nextFirst += 1;
        }

        float ratio = (float) size / items.length;
        if (items.length >=16 && ratio < 0.25) {
            items = reduceSize();
        }
        return result;
    }

    public T removeLast() {
        size -= 1;
        T result = null;
        if (nextLast != 0) {
            result = items[nextLast - 1];
            nextLast -= 1;
        } else {
            result = items[items.length - 1];
            nextLast = items.length - 1;
        }
        float ratio = (float) size / items.length;
        if (items.length >=16 && ratio < 0.25) {
            items = reduceSize();
        }
        return result;
    }

    public T get(int index) {
        return items[index];
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> ad = new ArrayDeque<>();

        for (int j = 0; j < 6; j++){
            ad.addFirst(j + 10);
        }
        for (int i = 0; i < 10; i++){
            ad.addLast(i);
        }
        for (int j = 0; j < 6; j++){
            ad.addFirst(j + 10);
        }
        ad.addLast(88);
        for (int k = 0; k < 20; k++) {
            ad.removeFirst();
        }



    }
}
