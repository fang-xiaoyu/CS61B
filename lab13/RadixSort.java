import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * Class for doing Radix sort
 *
 * @author Akhil Batra, Alexander Hwang
 *
 */
public class RadixSort {
    /**
     * Does LSD radix sort on the passed in array with the following restrictions:
     * The array can only have ASCII Strings (sequence of 1 byte characters)
     * The sorting is stable and non-destructive
     * The Strings can be variable length (all Strings are not constrained to 1 length)
     *
     * @param asciis String[] that needs to be sorted
     *
     * @return String[] the sorted array
     */
    public static String[] sort(String[] asciis) {
        // TODO: Implement LSD Sort
        // 1. 求解输入的最长字符串长度
        int maxLength = Integer.MIN_VALUE; // max length
        for (String s: asciis) {
            maxLength = maxLength > s.length() ? maxLength: s.length();
        }

        int N = asciis.length;
        int R = 256;
        String[] aux = new String[N];

        for (int d = maxLength; d >= 0; d--) {
            int[] count = new int[R+1];
            for (int i = 0; i < N; i++) {
                count[asciis[i].charAt(d) + 1] += 1;
            }

            for (int r = 0; r < R; r++) {
                count[r+1] += count[r];
            }

            for (int i = 0; i < N; i++) {
                aux[count[asciis[i].charAt(d)]++] = asciis[i];
            }

            for (int i = 0; i < N; i++) {
                asciis[i] = aux[i];
            }
        }
        return asciis;
    }

    /**
     * LSD helper method that performs a destructive counting sort the array of
     * Strings based off characters at a specific index.
     * @param asciis Input array of Strings
     * @param index The position to sort the Strings on.
     */
    private static void sortHelperLSD(String[] asciis, int index) {
        // Optional LSD helper method for required LSD radix sort
        return;
    }

    /**
     * MSD radix sort helper function that recursively calls itself to achieve the sorted array.
     * Destructive method that changes the passed in array, asciis.
     *
     * @param asciis String[] to be sorted
     * @param start int for where to start sorting in this method (includes String at start)
     * @param end int for where to end sorting in this method (does not include String at end)
     * @param index the index of the character the method is currently sorting on
     *
     **/
    private static void sortHelperMSD(String[] asciis, int start, int end, int index) {
        // Optional MSD helper method for optional MSD radix sort
        return;
    }

    public static void main(String[] args) {


        Map<Character, Integer> map = new HashMap<>();
        String s = "ssss";
        s.toCharArray();
        int[] a = {1};
        int[] b = {2};
        List<Integer> l  =new ArrayList();

        PriorityQueue<Integer> pq  =new PriorityQueue<>();
        pq.offer(2);
        pq.offer(1);
        int i = pq.poll();

    }
}
