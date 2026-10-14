import java.util.Arrays;
import java.util.Scanner;

public class SecondBestScore {

    /**
     * Returns the second-highest distinct score from a sorted (ascending) scores array.
     * Returns -1 if no second-best score exists (all scores are identical or array has < 2 elements).
     */
    public static int secondBestScore(int[] scores) {
        if (scores == null || scores.length < 2) {
            return -1;
        }

        int best = Integer.MIN_VALUE;
        int secondBest = Integer.MIN_VALUE;

        for (int score : scores) {
            if (score > best) {
                secondBest = best;
                best = score;
            } else if (score > secondBest && score < best) {
                secondBest = score;
            }
        }

        return (secondBest == Integer.MIN_VALUE) ? -1 : secondBest;
    }

    public static void main(String[] args) {
        // Sample 1: distinct values
        int[] scores1 = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};
        System.out.println(secondBestScore(scores1));   // Expected: 71

        // Sample 2: all identical
        int[] scores2 = {90, 90, 90};
        System.out.println(secondBestScore(scores2));   // Expected: -1

        // Sample 3: only two elements
        int[] scores3 = {55, 100};
        System.out.println(secondBestScore(scores3));   // Expected: 55

        // Sample 4: two identical elements
        int[] scores4 = {75, 75};
        System.out.println(secondBestScore(scores4));   // Expected: -1
    }
}
