import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Room {
    protected int units;

    public Room(int units) {
        this.units = units;
    }

    public abstract String getType();
    public abstract double calculateBill();
}

class SingleRoom extends Room {
    public SingleRoom(int units) {
        super(units);
    }

    @Override
    public String getType() {
        return "SINGLE";
    }

    @Override
    public double calculateBill() {
        return units * 8.0;
    }
}

class SharedRoom extends Room {
    private int occupants;

    public SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    @Override
    public String getType() {
        return "SHARED";
    }

    @Override
    public double calculateBill() {
        return (units * 6.0) / occupants;
    }
}

class ACRoom extends Room {
    public ACRoom(int units) {
        super(units);
    }

    @Override
    public String getType() {
        return "AC";
    }

    @Override
    public double calculateBill() {
        return (units * 10.0) + 200.0;
    }
}

public class HostelElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            sc.close();
            return;
        }

        int n = sc.nextInt();
        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();

            if ("SINGLE".equalsIgnoreCase(type)) {
                rooms.add(new SingleRoom(units));
            } else if ("SHARED".equalsIgnoreCase(type)) {
                int occupants = sc.nextInt();
                rooms.add(new SharedRoom(units, occupants));
            } else if ("AC".equalsIgnoreCase(type)) {
                rooms.add(new ACRoom(units));
            }
        }

        double grandTotal = 0;
        for (Room r : rooms) {
            double bill = r.calculateBill();
            grandTotal += bill;
            System.out.printf("%s: %.2f%n", r.getType(), bill);
        }

        System.out.printf("Total: %.2f%n", grandTotal);
        sc.close();
    }
}
