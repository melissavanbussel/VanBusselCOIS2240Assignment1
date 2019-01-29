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
    }
    public static int fibSeriesRec(int n) {
        if ((n == 0) || (n == 1))
            return n;
        else
            return fibSeriesRec(n - 1) + fibSeriesRec(n - 2);
    }
}
