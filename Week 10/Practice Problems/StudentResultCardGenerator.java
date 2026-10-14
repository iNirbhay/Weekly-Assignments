import java.util.Scanner;

class StudentCard {
    private String name;
    private int[] marks;

    public StudentCard(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    public double calculateAverage() {
        if (marks == null || marks.length == 0) return 0.0;
        int sum = 0;
        for (int m : marks) {
            sum += m;
        }
        return (double) sum / marks.length;
    }

    public char calculateGrade() {
        double avg = calculateAverage();
        if (avg >= 75.0) {
            return 'B';
        } else if (avg >= 60.0) {
            return 'C';
        } else if (avg >= 40.0) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public void printResultCard() {
        System.out.printf("%s: Average %.1f, Grade %c%n", name.toUpperCase(), calculateAverage(), calculateGrade());
    }
}

public class StudentResultCardGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String name = sc.next();
            if (!sc.hasNextLine()) break;
            String line = sc.nextLine().replace("[", "").replace("]", "").trim();
            if (line.isEmpty()) continue;
            String[] parts = line.split("[,\\s]+");
            int[] marks = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                marks[i] = Integer.parseInt(parts[i].trim());
            }

            StudentCard card = new StudentCard(name, marks);
            card.printResultCard();
        }
        sc.close();
    }
}
