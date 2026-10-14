import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class TravelBooking {
    protected static final double BOOKING_FEE = 50.0;
    protected double distanceKm;

    public TravelBooking(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public abstract String getMode();
    public abstract double calculateBaseFare();

    public double calculateTotalFare() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends TravelBooking {
    public BusBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public String getMode() {
        return "BUS";
    }

    @Override
    public double calculateBaseFare() {
        return distanceKm * 2.0;
    }
}

class TrainBooking extends TravelBooking {
    public TrainBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public String getMode() {
        return "TRAIN";
    }

    @Override
    public double calculateBaseFare() {
        return distanceKm * 1.5;
    }
}

class FlightBooking extends TravelBooking {
    public FlightBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public String getMode() {
        return "FLIGHT";
    }

    @Override
    public double calculateBaseFare() {
        return 2500.0 + (distanceKm * 4.0);
    }
}

public class TravelBookingWithCommonFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            sc.close();
            return;
        }

        int n = sc.nextInt();
        List<TravelBooking> bookings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();

            if ("BUS".equalsIgnoreCase(mode)) {
                bookings.add(new BusBooking(distance));
            } else if ("TRAIN".equalsIgnoreCase(mode)) {
                bookings.add(new TrainBooking(distance));
            } else if ("FLIGHT".equalsIgnoreCase(mode)) {
                bookings.add(new FlightBooking(distance));
            }
        }

        for (TravelBooking b : bookings) {
            System.out.printf("%s: %.2f%n", b.getMode(), b.calculateTotalFare());
        }

        sc.close();
    }
}
