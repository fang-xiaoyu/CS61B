import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        boolean actual1 = palindrome.isPalindrome("noon");
        boolean actual2 = palindrome.isPalindrome("a");
        boolean actual3 = palindrome.isPalindrome("");
        boolean actual4 = palindrome.isPalindrome("cat");
        boolean actual5 = palindrome.isPalindrome("Noon");

        assertEquals(true, actual1);
        assertEquals(true, actual2);
        assertEquals(true, actual3);
        assertEquals(false, actual4);
        assertEquals(false, actual5);
    }

    static CharacterComparator cc = new OffByOne();
    /**
    @Test
    public void testIsPalindromeCc() {
        boolean result = palindrome.isPalindrome("noon", cc);
        assertTrue(palindrome.isPalindrome("noon", cc));
        assertTrue(palindrome.isPalindrome("n", cc));
        assertTrue(palindrome.isPalindrome("", cc));
        assertFalse(palindrome.isPalindrome("cat", cc));
        assertFalse(palindrome.isPalindrome("Noon", cc));
    }
*/
    @Test
    public void testIsOffByOne() {
        assertTrue(palindrome.isPalindrome("flake", cc));
        assertTrue(palindrome.isPalindrome("a", cc));
        assertTrue(palindrome.isPalindrome("", cc));
        assertFalse(palindrome.isPalindrome("car", cc));
    }
}
