package week9.assignment_problems;

import java.util.Scanner;

public class GardenPlotAreaReport {
    static abstract class Plot {
        private final String owner;

        Plot(String owner) {
            this.owner = owner;
        }

        abstract double area();

        abstract String shape();

        String owner() {
            return owner;
        }
    }

    static class Circle extends Plot {
        private final double radius;

        Circle(String owner, double radius) {
            super(owner);
            this.radius = radius;
        }

        @Override
        double area() {
            return Math.PI * radius * radius;
        }

        @Override
        String shape() {
            return "CIRCLE";
        }
    }

    static class Rectangle extends Plot {
        private final double length;
        private final double width;

        Rectangle(String owner, double length, double width) {
            super(owner);
            this.length = length;
            this.width = width;
        }

        @Override
        double area() {
            return length * width;
        }

        @Override
        String shape() {
            return "RECTANGLE";
        }
    }

    static class Triangle extends Plot {
        private final double base;
        private final double height;

        Triangle(String owner, double base, double height) {
            super(owner);
            this.base = base;
            this.height = height;
        }

        @Override
        double area() {
            return 0.5 * base * height;
        }

        @Override
        String shape() {
            return "TRIANGLE";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of plots: ");
        int count = scanner.nextInt();
        double total = 0;

        for (int i = 0; i < count; i++) {
            System.out.print("Enter shape, owner, and measurements: ");
            String type = scanner.next();
            String owner = scanner.next();
            Plot plot;
            if (type.equals("CIRCLE")) {
                plot = new Circle(owner, scanner.nextDouble());
            } else if (type.equals("RECTANGLE")) {
                plot = new Rectangle(owner, scanner.nextDouble(), scanner.nextDouble());
            } else {
                plot = new Triangle(owner, scanner.nextDouble(), scanner.nextDouble());
            }
            double area = plot.area();
            total += area;
            System.out.printf("%s (%s): %.2f%n", plot.owner(), plot.shape(), area);
        }
        System.out.printf("Total Area: %.2f%n", total);
    }
}
