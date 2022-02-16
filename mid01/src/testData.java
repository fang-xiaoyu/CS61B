import org.junit.Test;
import static org.junit.Assert.*;

public class testData {
    @Test
    public void testSans() {
        int[] x = {1, 2, 3, 4, 5, 6, 2, 2, 3, 3};
        int y = 2;
        int[] expected = {1, 3, 4, 5, 6, 3, 3};
        int[] actual = Dada.sans(x, y);
        assertArrayEquals(expected, actual);
    }
}
