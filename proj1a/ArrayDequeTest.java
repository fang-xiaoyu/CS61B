import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {
    @Test
    public void testAddLast() {
        ArrayDeque<String> input = new ArrayDeque<>();
        input.addLast("i");
        String[] expected = new String[] {"i"};
        assertArrayEquals(input.items, expected);
        assertEquals(input.size, 1);

        input.addLast("am");
        String[] expected2 = new String[] {"i", "am"};
        assertArrayEquals(input.items, expected2);
        assertEquals(input.size, 2);
    }
}
