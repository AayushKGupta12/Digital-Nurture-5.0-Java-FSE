package Week_1.module4.AdvancedJUnitExercises.Exercise3;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderedTests {

    @Test
    @Order(1)
    void first(){

        System.out.println("First Test");

    }

    @Test
    @Order(2)
    void second(){

        System.out.println("Second Test");

    }

    @Test
    @Order(3)
    void third(){

        System.out.println("Third Test");

    }

}