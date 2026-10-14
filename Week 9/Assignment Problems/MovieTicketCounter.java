import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class MovieTicket {
    protected static final double CONVENIENCE_FEE = 20.0;
    protected int count;

    public MovieTicket(int count) {
        this.count = count;
    }

    public abstract String getSeatType();
    public abstract double getBasePricePerTicket();

    public double calculateAmount() {
        return count * (getBasePricePerTicket() + CONVENIENCE_FEE);
    }
}

class RegularTicket extends MovieTicket {
    public RegularTicket(int count) {
        super(count);
    }

    @Override
    public String getSeatType() {
        return "REGULAR";
    }

    @Override
    public double getBasePricePerTicket() {
        return 150.0;
    }
}

class PremiumTicket extends MovieTicket {
    public PremiumTicket(int count) {
        super(count);
    }

    @Override
    public String getSeatType() {
        return "PREMIUM";
    }

    @Override
    public double getBasePricePerTicket() {
        return 250.0;
    }
}

class ReclinerTicket extends MovieTicket {
    public ReclinerTicket(int count) {
        super(count);
    }

    @Override
    public String getSeatType() {
        return "RECLINER";
    }

    @Override
    public double getBasePricePerTicket() {
        return 400.0;
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            sc.close();
            return;
        }

        int n = sc.nextInt();
        List<MovieTicket> bookings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();

            if ("REGULAR".equalsIgnoreCase(seat)) {
                bookings.add(new RegularTicket(count));
            } else if ("PREMIUM".equalsIgnoreCase(seat)) {
                bookings.add(new PremiumTicket(count));
            } else if ("RECLINER".equalsIgnoreCase(seat)) {
                bookings.add(new ReclinerTicket(count));
            }
        }

        double total = 0;
        for (MovieTicket t : bookings) {
            double amount = t.calculateAmount();
            total += amount;
            System.out.printf("%s: %.2f%n", t.getSeatType(), amount);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
