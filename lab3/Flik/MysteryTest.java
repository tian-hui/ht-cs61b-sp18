import static org.junit.Assert.*;

import org.junit.Test;

public class MysteryTest {

    @Test(timeout = 1000)
    public void testFlik(){
        assertTrue(Flik.isSameNumber(2, 2));
        assertTrue(Flik.isSameNumber(0, 0));
        assertFalse(Flik.isSameNumber(1, 3));
        assertFalse(Flik.isSameNumber(0, 2));

        assertTrue(Flik.isSameNumber(128, 128));
    }
}
