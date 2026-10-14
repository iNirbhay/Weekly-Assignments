import java.util.Scanner;

public class FactorialCalculation {
    public static long factorial(int n) {
        if (n <= 1) return 1;
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            System.out.println(factorial(n));
        }
        sc.close();
    }
}
