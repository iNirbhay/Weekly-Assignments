import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class ElectricityConnection {
    protected int units;

    public ElectricityConnection(int units) {
        this.units = units;
    }

    public abstract String getType();
    public abstract double calculateBill();
}

class HomeConnection extends ElectricityConnection {
    public HomeConnection(int units) {
        super(units);
    }

    @Override
    public String getType() {
        return "HOME";
    }

    @Override
    public double calculateBill() {
        if (units <= 100) {
            return units * 5.0;
        } else {
            return (100 * 5.0) + ((units - 100) * 7.0);
        }
    }
}

class ShopConnection extends ElectricityConnection {
    public ShopConnection(int units) {
        super(units);
    }

    @Override
    public String getType() {
        return "SHOP";
    }

    @Override
    public double calculateBill() {
        return (units * 8.0) + 100.0;
    }
}

class FactoryConnection extends ElectricityConnection {
    public FactoryConnection(int units) {
        super(units);
    }

    @Override
    public String getType() {
        return "FACTORY";
    }

    @Override
    public double calculateBill() {
        return Math.max(1000.0, units * 6.0);
    }
}

public class ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            sc.close();
            return;
        }

        int n = sc.nextInt();
        List<ElectricityConnection> connections = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();

            if ("HOME".equalsIgnoreCase(type)) {
                connections.add(new HomeConnection(units));
            } else if ("SHOP".equalsIgnoreCase(type)) {
                connections.add(new ShopConnection(units));
            } else if ("FACTORY".equalsIgnoreCase(type)) {
                connections.add(new FactoryConnection(units));
            }
        }

        double total = 0;
        for (ElectricityConnection c : connections) {
            double bill = c.calculateBill();
            total += bill;
            System.out.printf("%s: %.2f%n", c.getType(), bill);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
