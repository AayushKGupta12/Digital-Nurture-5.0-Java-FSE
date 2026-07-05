package Week_1.module4.AdvancedJUnitExercises.Exercise4;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class PerformanceTesterTest {

    PerformanceTester tester = new PerformanceTester();

    @Test
    void testPerformance(){

        assertTimeout(Duration.ofSeconds(2),
                ()->tester.performTask());

    }

}
