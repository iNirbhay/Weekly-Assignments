import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class LibraryItem {
    protected String title;
    protected LocalDate checkoutDate;

    public LibraryItem(String title, LocalDate checkoutDate) {
        this.title = title;
        this.checkoutDate = checkoutDate;
    }

    public String getTitle() {
        return title;
    }

    public abstract LocalDate getDueDate();
}

class BookItem extends LibraryItem {
    public BookItem(String title, LocalDate checkoutDate) {
        super(title, checkoutDate);
    }

    @Override
    public LocalDate getDueDate() {
        return checkoutDate.plusDays(14);
    }
}

class DVDItem extends LibraryItem {
    public DVDItem(String title, LocalDate checkoutDate) {
        super(title, checkoutDate);
    }

    @Override
    public LocalDate getDueDate() {
        return checkoutDate.plusDays(7);
    }
}

class MagazineItem extends LibraryItem {
    public MagazineItem(String title, LocalDate checkoutDate) {
        super(title, checkoutDate);
    }

    @Override
    public LocalDate getDueDate() {
        return checkoutDate.plusDays(3);
    }
}

public class LibraryItemDueDateCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) {
            sc.close();
            return;
        }

        String nLine = sc.nextLine().trim();
        while (nLine.isEmpty() && sc.hasNextLine()) {
            nLine = sc.nextLine().trim();
        }
        if (nLine.isEmpty()) {
            sc.close();
            return;
        }

        int n = Integer.parseInt(nLine);
        LocalDate baseDate = LocalDate.parse("2023-10-26");
        List<LibraryItem> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!sc.hasNextLine()) break;
            String line = sc.nextLine().trim();
            while (line.isEmpty() && sc.hasNextLine()) {
                line = sc.nextLine().trim();
            }

            int firstSpace = line.indexOf(" ");
            if (firstSpace == -1) continue;

            String type = line.substring(0, firstSpace).trim();
            String title = line.substring(firstSpace + 1).trim();
            if (title.startsWith("\"") && title.endsWith("\"") && title.length() >= 2) {
                title = title.substring(1, title.length() - 1);
            }

            if ("BOOK".equalsIgnoreCase(type)) {
                items.add(new BookItem(title, baseDate));
            } else if ("DVD".equalsIgnoreCase(type)) {
                items.add(new DVDItem(title, baseDate));
            } else if ("MAGAZINE".equalsIgnoreCase(type)) {
                items.add(new MagazineItem(title, baseDate));
            }
        }

        for (LibraryItem item : items) {
            System.out.println(item.getTitle() + ": " + item.getDueDate());
        }

        sc.close();
    }
}
