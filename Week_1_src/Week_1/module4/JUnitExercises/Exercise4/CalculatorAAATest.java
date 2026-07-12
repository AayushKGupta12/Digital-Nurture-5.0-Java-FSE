package Week_1.module4.JUnitExercises.Exercise4;

import Week_1.module4.JUnitExercises.Exercise1.Calculator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorAAATest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Setup Completed");
    }

    @After
    public void tearDown() {
        calculator = null;
        System.out.println("Resources Released");
    }

    @Test
    public void testAddition() {
        int a = 10;
        int b = 5;
        int result = calculator.add(a, b);
        assertEquals(15, result);
    }

    @Test
    public void testMultiplication() {
        int c = 5;
        int d = 10;
        int result = calculator.mul(c, d);
        assertEquals(50, result);
    }
}