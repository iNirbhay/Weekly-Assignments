import java.util.Scanner;

public class EvenAndOddNumbersInAList {
    public static void countEvenOdd(int[] nums) {
        int even = 0;
        int odd = 0;

        for (int n : nums) {
            if (n % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            String line = sc.nextLine().replace("[", "").replace("]", "").trim();
            if (!line.isEmpty()) {
                String[] parts = line.split("[,\\s]+");
                int[] nums = new int[parts.length];
                for (int i = 0; i < parts.length; i++) {
                    nums[i] = Integer.parseInt(parts[i].trim());
                }
                countEvenOdd(nums);
            }
        }
        sc.close();
    }
}
