import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;
        Map<Integer, Integer> prefixSumFreq = new HashMap<>();

        // Base case: prefix sum of 0 appears once before any elements are processed
        prefixSumFreq.put(0, 1);

        for (int num : nums) {
            currentSum += num;

            if (prefixSumFreq.containsKey(currentSum - k)) {
                count += prefixSumFreq.get(currentSum - k);
            }

            prefixSumFreq.put(currentSum, prefixSumFreq.getOrDefault(currentSum, 0) + 1);
        }

        return count;
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
        System.out.print("Enter nums (e.g. 1, 1, 1): ");
        if (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            int[] nums;
            if (line.isEmpty()) {
                nums = new int[]{1, 1, 1};
            } else {
                nums = parseArray(line);
            }

            System.out.print("Enter k: ");
            int k = 2;
            if (sc.hasNextInt()) {
                k = sc.nextInt();
            } else if (sc.hasNextLine()) {
                String kLine = sc.nextLine().trim();
                if (!kLine.isEmpty()) {
                    k = Integer.parseInt(kLine);
                }
            }

            int result = subarraySum(nums, k);
            System.out.println(result);
        }
        sc.close();
    }
}
