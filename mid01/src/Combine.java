public class Combine {
    public static  int combine(ComFunc f, int[] x) {
        if (x.length == 0) {
            return 0;
        }
        if (x.length == 1) {
            return x[0];
        }
        return combineHelper(f, x, 1, x[0]);
    }

    private static int combineHelper(ComFunc f, int[] x, int count, int result) {
        result = f.apply(result, x[count]);
        count += 1;
        if (count == x.length) {
            return result;
        }
        return combineHelper(f, x, count, result);
    }
}
