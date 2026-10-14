import java.util.Scanner;

public class DigitSumAndNumberReversal {
    public static void processNumber(int n) {
        int temp = n;
        int sum = 0;
        int rev = 0;

        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            rev = rev * 10 + digit;
            temp /= 10;
        }

        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + rev);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            processNumber(n);
        }
        sc.close();
    }
}
