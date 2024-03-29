/* Melissa Van Bussel
* ID #0579124
* COIS2240
* Assignment 1, Question 2
* Due: February 4th, 2019
*/

// Import libraries for user input and for timing
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class question2_VanBussel_Melissa_Assignment1 {
    public static void main(String[] args) {
        int nFibonacci = askForUserInput();             // Call method which asks for the value of n

        // Calculate the Fib sequence using recursion, store the number of nanoseconds it took in elapsedTimeRec
        long elapsedTimeRec = callRecursiveFib(nFibonacci);
        // Calculate the Fib sequence using iteration, store the number of nanoseconds it took in elapsedTimeIte
        long elapsedTimeIte = callIterativeFib(nFibonacci);

        // Check which method was faster and print out by how much
        whichMethodFaster(elapsedTimeRec, elapsedTimeIte);
    }

    /** Compute the nth element in the Fibonacci sequence, using recursion
     * @param n The position number in the Fibonacci Sequence to be computed (int)
     * @return The nth element in the Fibonacci Sequence (int)
     */
    public static int fibSeriesRec(int n) {
        if ((n == 0) || (n == 1))
            return n;
        else
            return fibSeriesRec(n - 1) + fibSeriesRec(n - 2);
    }

    /** Compute the nth element in the Fibonacci Sequence using iteration
     * @param n The position number in the Fibonacci Sequence to be computed (int)
     * @return The nth element in the Fibonacci Sequence (int)
     */
    public static int fibSeriesIte(int n) {
        int firstFib = 0, secondFib = 1, newFib = 1;
        for (int i = 0; i < n; i++) {
            firstFib = secondFib;
            secondFib = newFib;
            newFib = firstFib + secondFib;
        }
        return firstFib;
    }

    /** Ask the user for the value of n and validate user input
     * @return The value of n that the user would like to use in order to compute the Fibonacci Sequence up to the nth element.
     */
    public static int askForUserInput() {
        Scanner userInput = new Scanner(System.in);         // Create Scanner object to get user input
        int nFibonacci;
        do {
            // Ask user how many numbers in the Fib sequence they want to calculate
            System.out.print("Enter the value of n (must be a positive integer) >> ");
            while (!userInput.hasNextInt()) {
                System.out.print("That isn't an integer! Enter the value of n (must be a positive integer) >> ");
                userInput.next();
            }
            nFibonacci = userInput.nextInt();               // Get input from user, store result in nFibonacci
            if (nFibonacci <= 0)
                System.out.print("That isn't a positive integer! Enter the value of n (must be a positive integer) >> ");
        } while (nFibonacci <= 0);
        return nFibonacci;
    }

    /** Display the first n elements of the Fibonacci sequence using recursion, calculate and display elapsed time
     * to do so
     * @param nFibonacci Elements of the Fibonacci Sequence up to the "nFibonacci"th element will be computed / displayed
     * @return The number of nanoseconds that the computation took
     */
    public static long callRecursiveFib(int nFibonacci) {
        System.out.println("The first " + nFibonacci + " integers in the Fibonacci Sequence, using the recursive method, are: ");
        long startTime = System.nanoTime();
        for (int i = 0; i < nFibonacci; i++) {
            if (i != 40)
                System.out.print(fibSeriesRec(i) + " ");
            else
                System.out.print("\n" + fibSeriesRec(i) + " ");
        }
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        System.out.println("\nThe elapsed time for the recursive method is " + elapsedTime + " nanoseconds");
        return elapsedTime;
    }

    /** Display the first n elements of the Fibonacci sequence using iteration, calculate and display elapsed time
     * to do so
     * @param nFibonacci Elements of the Fibonacci Sequence up to the "nFibonacci"th element will be computed / displayed
     * @return The number of nanoseconds that the computation took
     */
    public static long callIterativeFib(int nFibonacci) {
        System.out.println("The first " + nFibonacci + " integers in the Fibonacci Sequence, using the iterative method, are: ");
        long startTime = System.nanoTime();
        for (int i = 0; i < nFibonacci; i++) {
            if (i != 40)
                System.out.print(fibSeriesIte(i) + " ");
            else
                System.out.print("\n" + fibSeriesIte(i) + " ");
        }
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        System.out.println("\nThe elapsed time for the iterative method is " + elapsedTime + " nanoseconds");
        return elapsedTime;
    }

    /** Display whether recursion or iteration was faster, and by how much
     * @param elapsedTimeRec The number of nanoseconds that the calculation took, using recursion
     * @param elapsedTimeIte The number of nanoseconds that the calculation took, using iteration
     */
    public static void whichMethodFaster(long elapsedTimeRec, long elapsedTimeIte) {
        if (elapsedTimeRec < elapsedTimeIte) {
            long amountFaster = elapsedTimeIte - elapsedTimeRec;
            System.out.println("The recursive method was faster by " + amountFaster + " nanoseconds");
        } else {
            long amountFaster = elapsedTimeRec - elapsedTimeIte;
            System.out.print("The iterative method was faster by " + amountFaster + " nanoseconds");
        }
    }
}
