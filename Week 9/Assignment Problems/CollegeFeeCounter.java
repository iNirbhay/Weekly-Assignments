import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface BusUser {
    double getTransportFee();
}

abstract class StudentFee {
    protected static final double TRANSPORT_FEE = 12000.0;
    protected String name;

    public StudentFee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateBaseFee();

    public double calculateTotalFee() {
        double fee = calculateBaseFee();
        if (this instanceof BusUser) {
            fee += ((BusUser) this).getTransportFee();
        }
        return fee;
    }
}

class DayScholarStudent extends StudentFee implements BusUser {
    public DayScholarStudent(String name) {
        super(name);
    }

    @Override
    public double calculateBaseFee() {
        return 40000.0;
    }

    @Override
    public double getTransportFee() {
        return TRANSPORT_FEE;
    }
}

class HostellerStudent extends StudentFee {
    public HostellerStudent(String name) {
        super(name);
    }

    @Override
    public double calculateBaseFee() {
        return 40000.0 + 60000.0;
    }
}

class ScholarshipStudent extends StudentFee implements BusUser {
    public ScholarshipStudent(String name) {
        super(name);
    }

    @Override
    public double calculateBaseFee() {
        return 20000.0;
    }

    @Override
    public double getTransportFee() {
        return TRANSPORT_FEE;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            sc.close();
            return;
        }

        int n = sc.nextInt();
        List<StudentFee> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            if ("DAY_SCHOLAR".equalsIgnoreCase(type)) {
                students.add(new DayScholarStudent(name));
            } else if ("HOSTELLER".equalsIgnoreCase(type)) {
                students.add(new HostellerStudent(name));
            } else if ("SCHOLAR".equalsIgnoreCase(type)) {
                students.add(new ScholarshipStudent(name));
            }
        }

        double total = 0;
        for (StudentFee s : students) {
            double fee = s.calculateTotalFee();
            total += fee;
            System.out.printf("%s: %.2f%n", s.getName(), fee);
        }

        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}
