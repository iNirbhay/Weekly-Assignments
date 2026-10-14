import java.util.Scanner;

public class CSVStudentRecordParser {
    public static void parseStudentRecord(String csvLine) {
        String[] fields = csvLine.split(",", -1);

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String name = fields[0].trim();
        String rollNumber = fields[1].trim();
        String department = fields[2].trim();

        if (name.isEmpty() || rollNumber.isEmpty() || department.isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.println("Name: " + name + " | Roll No: " + rollNumber
                + " | Dept: " + department);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter CSV record (Name,RollNumber,Department): ");
        String csvLine = scanner.nextLine();
        parseStudentRecord(csvLine);
        scanner.close();
    }
}
