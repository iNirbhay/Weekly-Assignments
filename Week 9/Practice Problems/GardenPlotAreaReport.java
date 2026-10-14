import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class GardenPlot {
    protected String owner;

    public GardenPlot(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public abstract String getShape();
    public abstract double calculateArea();
}

class CircularPlot extends GardenPlot {
    private double radius;

    public CircularPlot(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    @Override
    public String getShape() {
        return "CIRCLE";
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class RectangularPlot extends GardenPlot {
    private double length;
    private double width;

    public RectangularPlot(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    @Override
    public String getShape() {
        return "RECTANGLE";
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

class TriangularPlot extends GardenPlot {
    private double base;
    private double height;

    public TriangularPlot(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    @Override
    public String getShape() {
        return "TRIANGLE";
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

public class GardenPlotAreaReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            sc.close();
            return;
        }

        int n = sc.nextInt();
        List<GardenPlot> plots = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String shape = sc.next();
            String owner = sc.next();

            if ("CIRCLE".equalsIgnoreCase(shape)) {
                double radius = sc.nextDouble();
                plots.add(new CircularPlot(owner, radius));
            } else if ("RECTANGLE".equalsIgnoreCase(shape)) {
                double length = sc.nextDouble();
                double width = sc.nextDouble();
                plots.add(new RectangularPlot(owner, length, width));
            } else if ("TRIANGLE".equalsIgnoreCase(shape)) {
                double base = sc.nextDouble();
                double height = sc.nextDouble();
                plots.add(new TriangularPlot(owner, base, height));
            }
        }

        double totalArea = 0;
        for (GardenPlot p : plots) {
            double area = p.calculateArea();
            totalArea += area;
            System.out.printf("%s (%s): %.2f%n", p.getOwner(), p.getShape(), area);
        }

        System.out.printf("Total Area: %.2f%n", totalArea);
        sc.close();
    }
}
