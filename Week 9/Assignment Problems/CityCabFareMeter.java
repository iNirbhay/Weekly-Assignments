import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface NightServiceCapable {
}

abstract class CabTrip {
    protected double km;
    protected String timeOfDay;

    public CabTrip(double km, String timeOfDay) {
        this.km = km;
        this.timeOfDay = timeOfDay;
    }

    public abstract String getCabType();
    public abstract double getRatePerKm();

    public boolean isNightServiceAllowed() {
        return !"NIGHT".equalsIgnoreCase(timeOfDay) || (this instanceof NightServiceCapable);
    }

    public double calculateFare() {
        double baseFare = Math.max(100.0, km * getRatePerKm());
        if ("NIGHT".equalsIgnoreCase(timeOfDay)) {
            return baseFare * 1.20;
        }
        return baseFare;
    }
}

class MiniCab extends CabTrip {
    public MiniCab(double km, String timeOfDay) {
        super(km, timeOfDay);
    }

    @Override
    public String getCabType() {
        return "MINI";
    }

    @Override
    public double getRatePerKm() {
        return 10.0;
    }
}

class SedanCab extends CabTrip implements NightServiceCapable {
    public SedanCab(double km, String timeOfDay) {
        super(km, timeOfDay);
    }

    @Override
    public String getCabType() {
        return "SEDAN";
    }

    @Override
    public double getRatePerKm() {
        return 14.0;
    }
}

class SUVCab extends CabTrip implements NightServiceCapable {
    public SUVCab(double km, String timeOfDay) {
        super(km, timeOfDay);
    }

    @Override
    public String getCabType() {
        return "SUV";
    }

    @Override
    public double getRatePerKm() {
        return 18.0;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            sc.close();
            return;
        }

        int n = sc.nextInt();
        List<CabTrip> trips = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            if ("MINI".equalsIgnoreCase(type)) {
                trips.add(new MiniCab(km, time));
            } else if ("SEDAN".equalsIgnoreCase(type)) {
                trips.add(new SedanCab(km, time));
            } else if ("SUV".equalsIgnoreCase(type)) {
                trips.add(new SUVCab(km, time));
            }
        }

        double grandTotal = 0;
        for (CabTrip t : trips) {
            if (!t.isNightServiceAllowed()) {
                System.out.printf("%s: night service not available%n", t.getCabType());
            } else {
                double fare = t.calculateFare();
                grandTotal += fare;
                System.out.printf("%s: %.2f%n", t.getCabType(), fare);
            }
        }

        System.out.printf("Total: %.2f%n", grandTotal);
        sc.close();
    }
}
