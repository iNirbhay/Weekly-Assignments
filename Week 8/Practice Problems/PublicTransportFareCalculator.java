import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class PublicTransport {
    protected double distance;

    public PublicTransport(double distance) {
        this.distance = distance;
    }

    public abstract String getType();
    public abstract double calculateFare();
}

class BusTransport extends PublicTransport {
    public BusTransport(double distance) {
        super(distance);
    }

    @Override
    public String getType() {
        return "BUS";
    }

    @Override
    public double calculateFare() {
        double fare = 2.0 + (0.10 * distance);
        return Math.min(10.0, fare);
    }
}

class TrainTransport extends PublicTransport {
    public TrainTransport(double distance) {
        super(distance);
    }

    @Override
    public String getType() {
        return "TRAIN";
    }

    @Override
    public double calculateFare() {
        return 3.0 + (0.15 * distance);
    }
}

class MetroTransport extends PublicTransport {
    private double peakHourFactor;

    public MetroTransport(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    public String getType() {
        return "METRO";
    }

    @Override
    public double calculateFare() {
        return (1.50 + 0.20 * distance) * peakHourFactor;
    }
}

public class PublicTransportFareCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            sc.close();
            return;
        }

        int n = sc.nextInt();
        List<PublicTransport> journeys = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();

            if ("BUS".equalsIgnoreCase(type)) {
                journeys.add(new BusTransport(distance));
            } else if ("TRAIN".equalsIgnoreCase(type)) {
                journeys.add(new TrainTransport(distance));
            } else if ("METRO".equalsIgnoreCase(type)) {
                double peak = sc.nextDouble();
                journeys.add(new MetroTransport(distance, peak));
            }
        }

        double totalFare = 0;
        for (PublicTransport t : journeys) {
            double fare = t.calculateFare();
            totalFare += fare;
            System.out.printf("%s: %.2f%n", t.getType(), fare);
        }

        System.out.printf("Total: %.2f%n", totalFare);
        sc.close();
    }
}
