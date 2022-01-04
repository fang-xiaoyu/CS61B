public class AList {
    private int[] items;
    private int size;


    public AList() {
        items = new int[100];    // (Item[]: cast)
        size = 0;
    }

    public static int[] insert(int[] arr, int item, int position) {
        int[] result = new int[arr.length + 1];
        if (arr.length == 0 || position > arr.length - 1) {
            result[arr.length] = item;
        }
        for (int i = 0; i < position; i++) {
            result[i] = arr[i];
        }
        result[position] = item;
        for (int i = position + 1; i < arr.length + 1; i++) {
            result[i] = arr[i - 1];
        }
        return result;
    }

    public static void reverse(int[] arr) {
        int[] copy = arr;
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = copy[arr.length - i - 1];
            copy[arr.length - i - 1] = temp;
        }
    }

    public static int[] replicate(int[] arr) {
        int length = 0;
        for (int i = 0; i < arr.length; i++) {
            length += arr[i];
        }
        int[] result = new int[length];
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            int item = arr[i];
            for (int j = item; j > 0; j--) {
                result[total + j - 1] = item;
            }
            total += item;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {3, 2, 1};
        int[] result = replicate(arr);

    }
}