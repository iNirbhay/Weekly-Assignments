import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface SaverModeCapable {
}

abstract class Appliance {
    protected double hours;
    protected boolean saverRequested;

    public Appliance(double hours, boolean saverRequested) {
        this.hours = hours;
        this.saverRequested = saverRequested;
    }

    public abstract String getName();
    public abstract double getPowerRating();

    public boolean isSaverSupported() {
        return !saverRequested || (this instanceof SaverModeCapable);
    }

    public double calculateUnits() {
        double units = (getPowerRating() * hours) / 1000.0;
        if (saverRequested && (this instanceof SaverModeCapable)) {
            units *= 0.75;
        }
        return units;
    }

    public double calculateCost() {
        return calculateUnits() * 8.0;
    }
}

class FridgeAppliance extends Appliance {
    public FridgeAppliance(double hours, boolean saverRequested) {
        super(hours, saverRequested);
    }

    @Override
    public String getName() {
        return "FRIDGE";
    }

    @Override
    public double getPowerRating() {
        return 150.0;
    }
}

class ACAppliance extends Appliance implements SaverModeCapable {
    public ACAppliance(double hours, boolean saverRequested) {
        super(hours, saverRequested);
    }

    @Override
    public String getName() {
        return "AC";
    }

    @Override
    public double getPowerRating() {
        return 1500.0;
    }
}

class TVAppliance extends Appliance {
    public TVAppliance(double hours, boolean saverRequested) {
        super(hours, saverRequested);
    }

    @Override
    public String getName() {
        return "TV";
    }

    @Override
    public double getPowerRating() {
        return 100.0;
    }
}

class WasherAppliance extends Appliance implements SaverModeCapable {
    public WasherAppliance(double hours, boolean saverRequested) {
        super(hours, saverRequested);
    }

    @Override
    public String getName() {
        return "WASHER";
    }

    @Override
    public double getPowerRating() {
        return 500.0;
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            sc.close();
            return;
        }

        int n = sc.nextInt();
        List<Appliance> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String app = sc.next();
            double hours = sc.nextDouble();
            boolean saver = false;

            if (sc.hasNext("SAVER")) {
                sc.next();
                saver = true;
            }

            if ("FRIDGE".equalsIgnoreCase(app)) {
                list.add(new FridgeAppliance(hours, saver));
            } else if ("AC".equalsIgnoreCase(app)) {
                list.add(new ACAppliance(hours, saver));
            } else if ("TV".equalsIgnoreCase(app)) {
                list.add(new TVAppliance(hours, saver));
            } else if ("WASHER".equalsIgnoreCase(app)) {
                list.add(new WasherAppliance(hours, saver));
            }
        }

        double totalCost = 0;
        for (Appliance a : list) {
            if (!a.isSaverSupported()) {
                System.out.printf("%s: saver mode not supported%n", a.getName());
            } else {
                double units = a.calculateUnits();
                double cost = a.calculateCost();
                totalCost += cost;
                System.out.printf("%s: Units=%.2f Cost=%.2f%n", a.getName(), units, cost);
            }
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}
