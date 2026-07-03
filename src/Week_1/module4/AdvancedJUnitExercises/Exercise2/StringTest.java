package Week_1.module4.AdvancedJUnitExercises.Exercise2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringTest {

    @Test
    void testLength(){

        assertEquals(5,"Hello".length());

    }

}