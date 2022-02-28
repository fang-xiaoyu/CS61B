package hw3.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OomageTestUtility {
    public static boolean haveNiceHashCodeSpread(List<Oomage> oomages, int M) {
        /* TODO:
         * Write a utility function that returns true if the given oomages
         * have hashCodes that would distribute them fairly evenly across
         * M buckets. To do this, convert each oomage's hashcode in the
         * same way as in the visualizer, i.e. (& 0x7FFFFFFF) % M.
         * and ensure that no bucket has fewer than N / 50
         * Oomages and no bucket has more than N / 2.5 Oomages.
         */
        int N = oomages.size();
        double floor = N / 50;
        double ceil =  N / 2.5;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < M; i++) {
            map.put(i, 0);
        }
        for (Oomage o: oomages) {
            int bucketNum = (o.hashCode() & 0x7FFFFFFF) % M;
            map.put(bucketNum, map.get(bucketNum) + 1);
        }
        for (int i = 0; i < M; i++) {
            if (map.get(i) > ceil || map.get(i) < floor) {
                return false;
            }
        }
        return true;
    }
}
