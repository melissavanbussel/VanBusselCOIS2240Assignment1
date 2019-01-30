/* Melissa Van Bussel
* ID #0579124
* COIS2240
* Assignment 1, Question 2
* Due: February 4th, 2019
 */

// Import libraries for user input and timing
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class question2_VanBussel_Melissa_Assignment1 {
    public static void main(String[] args) {
        int nFibonacci;                                 // Create variable to store user's input
        Scanner userInput = new Scanner(System.in);     // Create Scanner object to get user input
        System.out.print("Enter the value of n >> ");   // Ask user how many numbers in the Fib sequence they want to calculate
        nFibonacci = userInput.nextInt();               // Get input from user, store result in nFibonacci

        // Calculate the Fib sequence using recursion, store the number of nanoseconds it took in elapsedTimeRec
        long elapsedTimeRec = callRecursiveFib(nFibonacci);
        // Calculate the Fib sequence using iteration, store the number of nanoseconds it took in elapsedTimeIte
        long elapsedTimeIte = callIterativeFib(nFibonacci);

        // Check which method was faster and print out by how much
        whichMethodFaster(elapsedTimeRec, elapsedTimeIte);
    }

    public static int fibSeriesRec(int n) {
        if ((n == 0) || (n == 1))
            return n;
        else
            return fibSeriesRec(n - 1) + fibSeriesRec(n - 2);
    }

    public static int fibSeriesIte(int n) {
        int firstFib = 0, secondFib = 1, newFib = 1;
        for (int i = 0; i < n; i++) {
            firstFib = secondFib;
            secondFib = newFib;
            newFib = firstFib + secondFib;
        }
        return firstFib;
    }

    public static long callRecursiveFib(int nFibonacci) {
        System.out.println("The first " + nFibonacci + " integers in the Fibonacci Sequence, using the recursive method, are: ");
        long startTime = System.nanoTime();
        for (int i = 0; i < nFibonacci; i++) {
            System.out.print(fibSeriesRec(i) + " ");
        }
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        System.out.println("\nThe elapsed time for the recursive method is " + elapsedTime + " nanoseconds");
        return elapsedTime;
    }

    public static long callIterativeFib(int nFibonacci) {
        System.out.println("The first " + nFibonacci + " integers in the Fibonacci Sequence, using the iterative method, are: ");
        long startTime = System.nanoTime();
        for (int i = 0; i < nFibonacci; i++) {
            System.out.print(fibSeriesIte(i) + " ");
        }
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        System.out.println("\nThe elapsed time for the recursive method is " + elapsedTime + " nanoseconds");
        return elapsedTime;
    }

    public static void whichMethodFaster(long elapsedTimeRec, long elapsedTimeIte) {
        if (elapsedTimeRec > elapsedTimeIte) {
            long amountFaster = elapsedTimeRec - elapsedTimeIte;
            System.out.println("The recursive method was faster by " + amountFaster + " nanoseconds");
        } else {
            long amountFaster = elapsedTimeIte - elapsedTimeRec;
            System.out.print("The iterative method was faster by " + amountFaster + " nanoseconds");
        }
    }
}
