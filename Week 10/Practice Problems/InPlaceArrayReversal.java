import java.util.Arrays;
import java.util.Scanner;

public class InPlaceArrayReversal {
    public static void reverseInPlace(int[] arr) {
        if (arr == null) return;
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
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
                reverseInPlace(nums);
                System.out.println(Arrays.toString(nums));
            }
        }
        sc.close();
    }
}
