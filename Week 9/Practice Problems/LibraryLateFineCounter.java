import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class LibraryItemFine {
    protected String title;
    protected int daysLate;

    public LibraryItemFine(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    public String getTitle() {
        return title;
    }

    public abstract double calculateFine();
}

class BookFine extends LibraryItemFine {
    public BookFine(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return daysLate * 2.0;
    }
}

class DVDFine extends LibraryItemFine {
    public DVDFine(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return Math.min(50.0, daysLate * 5.0);
    }
}

class MagazineFine extends LibraryItemFine {
    public MagazineFine(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return daysLate * 1.0;
    }
}

public class LibraryLateFineCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            sc.close();
            return;
        }

        int n = sc.nextInt();
        List<LibraryItemFine> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int days = sc.nextInt();

            if ("BOOK".equalsIgnoreCase(type)) {
                items.add(new BookFine(title, days));
            } else if ("DVD".equalsIgnoreCase(type)) {
                items.add(new DVDFine(title, days));
            } else if ("MAGAZINE".equalsIgnoreCase(type)) {
                items.add(new MagazineFine(title, days));
            }
        }

        double totalFines = 0;
        for (LibraryItemFine item : items) {
            double fine = item.calculateFine();
            totalFines += fine;
            System.out.printf("%s: %.2f%n", item.getTitle(), fine);
        }

        System.out.printf("Total Fines: %.2f%n", totalFines);
        sc.close();
    }
}
