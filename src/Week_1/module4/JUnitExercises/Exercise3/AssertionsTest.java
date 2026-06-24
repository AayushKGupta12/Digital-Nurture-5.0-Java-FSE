package Week_1.module4.JUnitExercises.Exercise3;

import org.junit.Test;

import static org.junit.Assert.*;

public class AssertionsTest {
    @Test
    public void testAssertions(){
        assertEquals(5,2 + 3);

        assertTrue(10 >5);

        assertFalse(10<5);

        String name = null;
        assertNull(name);

        Object obj = new Object();
        assertNotNull(obj);
    }
}
