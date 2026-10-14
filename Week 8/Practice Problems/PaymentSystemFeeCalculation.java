import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class PaymentMethod {
    protected double amount;

    public PaymentMethod(double amount) {
        this.amount = amount;
    }

    public abstract String getType();
    public abstract double calculateFinalAmount();
}

class CardPayment extends PaymentMethod {
    public CardPayment(double amount) {
        super(amount);
    }

    @Override
    public String getType() {
        return "CARD";
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 1.02;
    }
}

class WalletPayment extends PaymentMethod {
    public WalletPayment(double amount) {
        super(amount);
    }

    @Override
    public String getType() {
        return "WALLET";
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 1.01;
    }
}

class BankTransferPayment extends PaymentMethod {
    public BankTransferPayment(double amount) {
        super(amount);
    }

    @Override
    public String getType() {
        return "BANKTRANSFER";
    }

    @Override
    public double calculateFinalAmount() {
        return amount;
    }
}

public class PaymentSystemFeeCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            sc.close();
            return;
        }

        int n = sc.nextInt();
        List<PaymentMethod> payments = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            if ("CARD".equalsIgnoreCase(type)) {
                payments.add(new CardPayment(amount));
            } else if ("WALLET".equalsIgnoreCase(type)) {
                payments.add(new WalletPayment(amount));
            } else if ("BANKTRANSFER".equalsIgnoreCase(type)) {
                payments.add(new BankTransferPayment(amount));
            }
        }

        double grandTotal = 0;
        for (PaymentMethod p : payments) {
            double finalAmount = p.calculateFinalAmount();
            grandTotal += finalAmount;
            System.out.printf("%s: %.2f%n", p.getType(), finalAmount);
        }

        System.out.printf("Total: %.2f%n", grandTotal);
        sc.close();
    }
}
