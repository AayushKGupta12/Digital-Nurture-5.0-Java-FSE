//What is Recursion?
//
//        Recursion is a programming technique in which a method calls itself to solve a problem by breaking it into smaller subproblems.
//
//        A recursive function consists of:
//
//        Base Case: Stops the recursion.
//        Recursive Case: Calls the same function with a smaller problem.
//
//        Recursion makes code simpler and easier to understand for problems that have repetitive subproblems.
//
//        Future Value = Current Value × (1 + Growth Rate)

package Week_1.module2.Exercise7_Financial_Forecasting;
class Forecast {

    // Recursive Method
    public static double predictFutureValue(double currentValue, double growthRate, int years) {

        // Base Case
        if (years == 0) {
            return currentValue;
        }

        // Recursive Case
        return predictFutureValue(
                currentValue * (1 + growthRate),
                growthRate,
                years - 1
        );
    }
}

public class Main {

    public static void main(String[] args) {

        double currentValue = 10000;
        double growthRate = 0.10; // 10%
        int years = 5;

        double futureValue = Forecast.predictFutureValue(currentValue, growthRate, years);

        System.out.printf("Future Value after %d years = ₹%.2f",
                years,
                futureValue);
    }
}

//        Time Complexity: O(n)
//
//        where n is the number of years.
//
//
//        Optimization Techniques
//            Use Iteration
//                Replace recursion with a loop.
//                Reduces space complexity to O(1).
//            Memoization
//                Store previously computed results.
//                Avoids repeated calculations in problems with overlapping subproblems.
//            Dynamic Programming
//                Builds the solution iteratively.
//                More efficient for complex forecasting models.