public class Dada {
    private static String[] rs;

    /**
     * Prints out the given array, i.e. if d contains two Strings
     * with names "alice" and "bob", this method will print "alice bob ".
     */
    private static void printStringArray(String[] s) {
        for (int i = 0; i < s.length; i += 1) {
            System.out.print(s[i] + " ");
        }
        System.out.println();
    }

    private static void fillMany(String[] d) {
        System.arraycopy(Dada.rs, 0, d, 0, d.length);
    }
    private static void fillOne(String d) { d = Dada.rs[0]; }

    public static int f(int x) {
        if (x == 1) {
            return 1;
        }
        return 2 * f(x / 2);
    }

    public static int[] sans(int[] x, int y) {
        int[] xclean = new int[x.length];
        int c = 0;
        for (int i = 0; i < x.length; i += 1) {
            if (x[i] != y) {
                xclean[c] = x[i];
                c += 1;
            }
        }
        int[] r = new int[c];
        System.arraycopy(xclean, 0, r, 0, c);
        return r;
    }

    public static void main(String[] args) {
        System.out.println(f(0));
    }

}
