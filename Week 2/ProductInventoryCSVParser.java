import java.util.Scanner;

public class ProductInventoryCSVParser {

    public static void parseInventoryRecord(String csvLine) {
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }

        String[] fields = csvLine.split(",");
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String productName = fields[0].trim();
        String sku = fields[1].trim();
        String qty = fields[2].trim();

        System.out.println("Product: " + productName + " | SKU: " + sku + " | Qty: " + qty);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter CSV line: ");
        String csvLine = sc.nextLine();

        parseInventoryRecord(csvLine);

        sc.close();
    }
}
