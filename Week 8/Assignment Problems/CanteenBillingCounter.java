import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Customer {
    protected double amount;

    public Customer(double amount) {
        this.amount = amount;
    }

    public abstract String getType();
    public abstract double calculateFinalAmount();
}

class StudentCustomer extends Customer {
    public StudentCustomer(double amount) {
        super(amount);
    }

    @Override
    public String getType() {
        return "STUDENT";
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.90;
    }
}

class StaffCustomer extends Customer {
    public StaffCustomer(double amount) {
        super(amount);
    }

    @Override
    public String getType() {
        return "STAFF";
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.95;
    }
}

class GuestCustomer extends Customer {
    public GuestCustomer(double amount) {
        super(amount);
    }

    @Override
    public String getType() {
        return "GUEST";
    }

    @Override
    public double calculateFinalAmount() {
        return amount + 10.0;
    }
}

public class CanteenBillingCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            sc.close();
            return;
        }

        int n = sc.nextInt();
        List<Customer> bills = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            if ("STUDENT".equalsIgnoreCase(type)) {
                bills.add(new StudentCustomer(amount));
            } else if ("STAFF".equalsIgnoreCase(type)) {
                bills.add(new StaffCustomer(amount));
            } else if ("GUEST".equalsIgnoreCase(type)) {
                bills.add(new GuestCustomer(amount));
            }
        }

        double grandTotal = 0;
        for (Customer c : bills) {
            double finalAmount = c.calculateFinalAmount();
            grandTotal += finalAmount;
            System.out.printf("%s: %.2f%n", c.getType(), finalAmount);
        }

        System.out.printf("Total: %.2f%n", grandTotal);
        sc.close();
    }
}
