import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    @Test
    public void testOffByOne() {
        CharacterComparator offByOne = new OffByN(1);
        assertFalse(offByOne.equalChars('a', 'a'));
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('c', 'b'));
        assertFalse(offByOne.equalChars('A', 'a'));
        assertFalse(offByOne.equalChars('z', 'a'));
        assertTrue(offByOne.equalChars('&', '%'));
        assertFalse(offByOne.equalChars('&', 'c'));
        assertFalse(offByOne.equalChars('Z', 'a'));
        assertFalse(offByOne.equalChars('A','C'));
        assertTrue(offByOne.equalChars('B', 'C'));
    }

    @Test
    public void testOffByFive() {
        CharacterComparator offByFive = new OffByN(5);
        assertTrue(offByFive.equalChars('g', 'b'));
        assertTrue(offByFive.equalChars('i', 'n'));
        assertTrue(offByFive.equalChars('G', 'B'));
        assertFalse(offByFive.equalChars('a', 'b'));
        assertFalse(offByFive.equalChars('z', 'a'));
    }
}
