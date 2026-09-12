import java.util.Scanner;

public class FindMinimumInRotatedSortedArray {

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // Minimum must be in the right half
                left = mid + 1;
            } else {
                // Minimum is at mid or in the left half
                right = mid;
            }
        }

        return nums[left];
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
        System.out.print("Enter nums (e.g. 3, 4, 5, 1, 2): ");
        if (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            int[] nums;
            if (line.isEmpty()) {
                nums = new int[]{3, 4, 5, 1, 2};
            } else {
                nums = parseArray(line);
            }
            int result = findMin(nums);
            System.out.println(result);
        }
        sc.close();
    }
}
