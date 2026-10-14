import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Vehicle {
    protected int hours;

    public Vehicle(int hours) {
        this.hours = hours;
    }

    public abstract String getType();
    public abstract double calculateCharge();
}

class Bike extends Vehicle {
    public Bike(int hours) {
        super(hours);
    }

    @Override
    public String getType() {
        return "BIKE";
    }

    @Override
    public double calculateCharge() {
        return hours * 10.0;
    }
}

class Car extends Vehicle {
    public Car(int hours) {
        super(hours);
    }

    @Override
    public String getType() {
        return "CAR";
    }

    @Override
    public double calculateCharge() {
        if (hours <= 1) {
            return 30.0;
        }
        return 30.0 + (hours - 1) * 20.0;
    }
}

class Truck extends Vehicle {
    public Truck(int hours) {
        super(hours);
    }

    @Override
    public String getType() {
        return "TRUCK";
    }

    @Override
    public double calculateCharge() {
        return Math.max(100.0, hours * 50.0);
    }
}

public class CampusParkingChargeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            sc.close();
            return;
        }

        int n = sc.nextInt();
        List<Vehicle> vehicles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();

            if ("BIKE".equalsIgnoreCase(type)) {
                vehicles.add(new Bike(hours));
            } else if ("CAR".equalsIgnoreCase(type)) {
                vehicles.add(new Car(hours));
            } else if ("TRUCK".equalsIgnoreCase(type)) {
                vehicles.add(new Truck(hours));
            }
        }

        double grandTotal = 0;
        for (Vehicle v : vehicles) {
            double charge = v.calculateCharge();
            grandTotal += charge;
            System.out.printf("%s: %.2f%n", v.getType(), charge);
        }

        System.out.printf("Total: %.2f%n", grandTotal);
        sc.close();
    }
}
