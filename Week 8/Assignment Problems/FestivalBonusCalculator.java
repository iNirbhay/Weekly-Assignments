import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class CompanyEmployeeBonus {
    protected String name;
    protected double monthlySalary;

    public CompanyEmployeeBonus(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateBonus();
}

class FullTimeEmployee extends CompanyEmployeeBonus {
    public FullTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return monthlySalary * 0.10;
    }
}

class PartTimeEmployee extends CompanyEmployeeBonus {
    public PartTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return monthlySalary * 0.05;
    }
}

class InternEmployee extends CompanyEmployeeBonus {
    public InternEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return 2000.0;
    }
}

public class FestivalBonusCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            sc.close();
            return;
        }

        int n = sc.nextInt();
        List<CompanyEmployeeBonus> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            if ("FULLTIME".equalsIgnoreCase(type)) {
                employees.add(new FullTimeEmployee(name, salary));
            } else if ("PARTTIME".equalsIgnoreCase(type)) {
                employees.add(new PartTimeEmployee(name, salary));
            } else if ("INTERN".equalsIgnoreCase(type)) {
                employees.add(new InternEmployee(name, salary));
            }
        }

        double grandTotal = 0;
        for (CompanyEmployeeBonus emp : employees) {
            double bonus = emp.calculateBonus();
            grandTotal += bonus;
            System.out.printf("%s: %.2f%n", emp.getName(), bonus);
        }

        System.out.printf("Total Bonus: %.2f%n", grandTotal);
        sc.close();
    }
}
