import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ThreeSum {

    public static int[][] threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new int[0][0];
        }

        Arrays.sort(nums);
        List<int[]> resultList = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    resultList.add(new int[]{nums[i], nums[left], nums[right]});

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        int[][] answer = new int[resultList.size()][3];
        for (int k = 0; k < resultList.size(); k++) {
            answer[k] = resultList.get(k);
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
        System.out.print("Enter nums (e.g. -1, 0, 1, 2, -1, -4): ");
        if (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            int[] nums;
            if (line.isEmpty()) {
                nums = new int[]{-1, 0, 1, 2, -1, -4};
            } else {
                nums = parseArray(line);
            }
            int[][] result = threeSum(nums);
            System.out.println(Arrays.deepToString(result));
        }
        sc.close();
    }
}
