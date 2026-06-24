package Week_1.module4.AdvancedJUnitExercises.Exercise1;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;
public class EvenCheckerTest {

    EvenChecker checker = new EvenChecker();

    @ParameterizedTest
    @ValueSource(ints = {2,4,6,8,10,12})
    void testEvenNumbers(int number){
        assertTrue(checker.isEven(number));
    }
}
