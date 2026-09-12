import java.util.Scanner;

public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
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
        System.out.print("Enter nums (e.g. -2, 1, -3, 4, -1, 2, 1, -5, 4): ");
        if (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            int[] nums;
            if (line.isEmpty()) {
                nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
            } else {
                nums = parseArray(line);
            }
            int result = maxSubArray(nums);
            System.out.println(result);
        }
        sc.close();
    }
}
