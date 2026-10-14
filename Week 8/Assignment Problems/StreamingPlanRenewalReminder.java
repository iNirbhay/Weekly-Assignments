import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class SubscriptionPlan {
    protected String subscriberName;
    protected LocalDate startDate;

    public SubscriptionPlan(String subscriberName, LocalDate startDate) {
        this.subscriberName = subscriberName;
        this.startDate = startDate;
    }

    public String getSubscriberName() {
        return subscriberName;
    }

    public abstract LocalDate calculateRenewalDate();
}

class BasicPlan extends SubscriptionPlan {
    public BasicPlan(String subscriberName, LocalDate startDate) {
        super(subscriberName, startDate);
    }

    @Override
    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(30);
    }
}

class StandardPlan extends SubscriptionPlan {
    public StandardPlan(String subscriberName, LocalDate startDate) {
        super(subscriberName, startDate);
    }

    @Override
    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(90);
    }
}

class PremiumPlan extends SubscriptionPlan {
    public PremiumPlan(String subscriberName, LocalDate startDate) {
        super(subscriberName, startDate);
    }

    @Override
    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(365);
    }
}

public class StreamingPlanRenewalReminder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            sc.close();
            return;
        }

        int n = sc.nextInt();
        List<SubscriptionPlan> subscriptions = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String planType = sc.next();
            String name = sc.next();
            String dateStr = sc.next();
            LocalDate startDate = LocalDate.parse(dateStr);

            if ("BASIC".equalsIgnoreCase(planType)) {
                subscriptions.add(new BasicPlan(name, startDate));
            } else if ("STANDARD".equalsIgnoreCase(planType)) {
                subscriptions.add(new StandardPlan(name, startDate));
            } else if ("PREMIUM".equalsIgnoreCase(planType)) {
                subscriptions.add(new PremiumPlan(name, startDate));
            }
        }

        for (SubscriptionPlan sub : subscriptions) {
            System.out.println(sub.getSubscriberName() + ": " + sub.calculateRenewalDate());
        }

        sc.close();
    }
}
