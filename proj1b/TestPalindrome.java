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
        assertFalse(palindrome.isPalindrome("cat"));
        assertTrue(palindrome.isPalindrome("a"));
        assertFalse(palindrome.isPalindrome("Aa"));
        assertTrue(palindrome.isPalindrome(""));
    }

    @Test
    public void testOffByOnePalindrome() {
        CharacterComparator offByOne = new OffByOne();
        assertTrue(palindrome.isPalindrome("", offByOne));
        assertTrue(palindrome.isPalindrome("a", offByOne));
        assertTrue(palindrome.isPalindrome("ab", offByOne));
        assertTrue(palindrome.isPalindrome("ba", offByOne));
        assertTrue(palindrome.isPalindrome("aab", offByOne));
        assertTrue(palindrome.isPalindrome("aacdbb", offByOne));
        assertTrue(palindrome.isPalindrome("aaddcbb", offByOne));
        assertFalse(palindrome.isPalindrome("aa", offByOne));
        assertFalse(palindrome.isPalindrome("cat", offByOne));
        assertFalse(palindrome.isPalindrome("cbbd", offByOne));
        assertFalse(palindrome.isPalindrome("q q", offByOne));
        assertFalse(palindrome.isPalindrome("Adb", offByOne));
        assertFalse(palindrome.isPalindrome("az", offByOne));
    }

    @Test
    public void testOffByNPalindrome() {
        CharacterComparator offByFive = new OffByN(5);
        assertTrue(palindrome.isPalindrome("binding", offByFive));
    }

}
