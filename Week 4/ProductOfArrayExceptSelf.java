import java.util.Arrays;
import java.util.Scanner;

public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Forward pass: prefix products
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Backward pass: multiply running suffix products
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * suffix;
            suffix *= nums[i];
        }

        return answer;
    }

    private static int[] parseArray(String line) {
        line = line.replace("[", "").replace("]", "").trim();
        if (line.isEmpty()) return new int[0];
        String[] parts = line.split("[,\\s]+");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i].trim());
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter nums (e.g. 1, 2, 3, 4): ");
        if (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            int[] nums;
            if (line.isEmpty()) {
                nums = new int[]{1, 2, 3, 4};
            } else {
                nums = parseArray(line);
            }
            int[] result = productExceptSelf(nums);
            System.out.println(Arrays.toString(result));
        }
        sc.close();
    }
}
