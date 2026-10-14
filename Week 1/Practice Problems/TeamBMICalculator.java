import java.util.Scanner;

public class TeamBMICalculator {
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi < 25.0) return "Normal";
        if (bmi < 30.0) return "Overweight";
        return "Obese";
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        if (heights.length != weights.length) {
            throw new IllegalArgumentException("Heights and weights must have the same length.");
        }

        System.out.printf("%-8s | %-12s | %-12s | %-8s | %-12s%n",
                "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("----------------------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {
            if (heights[i] <= 0 || weights[i] <= 0) {
                System.out.printf("%-8d | Invalid height or weight%n", i + 1);
                continue;
            }
            double bmi = weights[i] / (heights[i] * heights[i]);
            System.out.printf("%-8d | %-12.2f | %-12.2f | %-8.2f | %-12s%n",
                    i + 1, heights[i], weights[i], bmi, getBmiStatus(bmi));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of people: ");
        int count = scanner.nextInt();

        if (count <= 0) {
            System.out.println("Number of people must be positive.");
            scanner.close();
            return;
        }

        double[] heights = new double[count];
        double[] weights = new double[count];

        for (int i = 0; i < count; i++) {
            System.out.print("Person " + (i + 1) + " height in meters: ");
            heights[i] = scanner.nextDouble();
            System.out.print("Person " + (i + 1) + " weight in kg: ");
            weights[i] = scanner.nextDouble();
        }

        printWellnessReport(heights, weights);
        scanner.close();
    }
}
