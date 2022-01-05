import org.junit.Test;
import static org.junit.Assert.*;

public class Filktest {
    @Test
    public void testIsSameNumber() {
        int a = 555;
        int b = 10;
        int c = 555;
        boolean expected1 = false;
        boolean expected2 = true;
        boolean actual1 = Flik.isSameNumber(a, b);
        boolean actual2 = Flik.isSameNumber(a, c);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }
}
