package Week_1.module4.AdvancedJUnitExercises.Exercise4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExceptionThrowerTest {

    ExceptionThrower obj = new ExceptionThrower();

    @Test
    void testException(){

        assertThrows(ArithmeticException.class,
                ()->obj.throwException());

    }

}
