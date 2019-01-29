import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class question2_VanBussel_Melissa_Assignment1 {
    public static void main(String[] args) {
        int nFibonacci;
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter the value of n >> ");
        nFibonacci = userInput.nextInt();
        System.out.println("The first " + nFibonacci + " integers in the Fibonacci Sequence, using the recursive method, are: ");
        long startTimeRec = System.nanoTime();
        for (int i = 0; i < nFibonacci; i++) {
            System.out.print(fibSeriesRec(i) + " ");
        }
        long endTimeRec = System.nanoTime();
        long elapsedTimeRec = endTimeRec - startTimeRec;
        System.out.println("\nThe elapsed time for the recursive method is " + elapsedTimeRec + " nanoseconds");
        System.out.println("The first " + nFibonacci + " integers in the Fibonacci Sequence, using the iterative method, are: ");
        long startTimeIte = System.nanoTime();
        for (int i = 0; i < nFibonacci; i++) {
            System.out.print(fibSeriesIte(i) + " ");
        }
        long endTimeIte = System.nanoTime();
        long elapsedTimeIte = endTimeIte - startTimeIte;
        System.out.println("\nThe elapsed time for the recursive method is " + elapsedTimeIte + " nanoseconds");
        // Check which method was faster and print out by how much
        if (elapsedTimeRec > elapsedTimeIte) {
            long amountFaster = elapsedTimeRec - elapsedTimeIte;
            System.out.println("The recursive method was faster by " + amountFaster + " nanoseconds");
        } else {
            long amountFaster = elapsedTimeIte - elapsedTimeRec;
            System.out.print("The iterative method was faster by " + amountFaster + " nanoseconds");
        }
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
}
