import java.util.Scanner;
public class question2_VanBussel_Melissa_Assignment1 {
    public static void main(String[] args) {
        int nFibonacci;
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter the value of n >> ");
        nFibonacci = userInput.nextInt();
        System.out.println("The first " + nFibonacci + " integers in the Fibonacci Sequence, using the recursive method, are: ");
        for (int i = 0; i < nFibonacci; i++) {
            System.out.print(fibSeriesRec(i) + " ");
        }
        System.out.println("The first " + nFibonacci + " integers in the Fibonacci Sequence, using the iterative method, are: ");
        for (int i = 0; i < nFibonacci; i++) {
            System.out.print(fibSeriesIte(i) + " ");
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
