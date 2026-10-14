import java.util.Scanner;

public class BusiestBusRow {

    public static int[] busiestRow(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return new int[]{-1, 0};
        }

        int bestRowIndex = 0;
        int largestTotal = -1;

        for (int r = 0; r < grid.length; r++) {
            int rowSum = 0;
            if (grid[r] != null) {
                for (int seat : grid[r]) {
                    rowSum += seat;
                }
            }
            if (rowSum > largestTotal) {
                largestTotal = rowSum;
                bestRowIndex = r;
            }
        }

        return new int[]{bestRowIndex, largestTotal};
    }

    public static void main(String[] args) {
        int[][] grid = {
            {2, 0, 1},
            {3, 3, 1},
            {1, 1, 1}
        };

        int[] result = busiestRow(grid);
        System.out.println("Row " + result[0] + ", Total " + result[1]);
    }
}
