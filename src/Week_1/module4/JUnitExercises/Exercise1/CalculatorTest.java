package Week_1.module4.JUnitExercises.Exercise1;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    Calculator calculator = new Calculator();
    @Test
    public void testAdd(){
        assertEquals(15, calculator.add(10,5));
    }
    @Test
    public void testSub(){
        assertEquals(15,calculator.sub(10,3));
    }

    @Test
    public void testMul(){
        assertEquals(10,calculator.mul(5,2));
    }
    @Test
    public void testDiv(){
        assertEquals(2,calculator.div(10,5));
    }

}
