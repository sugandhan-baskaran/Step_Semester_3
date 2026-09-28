package week8.assignment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PublicTransportFare {
    private interface Journey {
        double fare();
        String type();
    }

    private record Bus(double distance) implements Journey {
        @Override
        public double fare() { return Math.min(10, 2 + 0.1 * distance); }
        @Override
        public String type() { return "BUS"; }
    }

    private record Train(double distance) implements Journey {
        @Override
        public double fare() { return 3 + 0.15 * distance; }
        @Override
        public String type() { return "TRAIN"; }
    }

    private record Metro(double distance, double peakHourFactor) implements Journey {
        @Override
        public double fare() { return (1.5 + 0.2 * distance) * peakHourFactor; }
        @Override
        public String type() { return "METRO"; }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int count = scanner.nextInt();
            List<Journey> journeys = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                String type = scanner.next();
                double distance = scanner.nextDouble();
                journeys.add(type.equals("BUS") ? new Bus(distance)
                        : type.equals("TRAIN") ? new Train(distance)
                        : new Metro(distance, scanner.nextDouble()));
            }
            double total = 0;
            for (Journey journey : journeys) {
                total += journey.fare();
                System.out.printf("%s: %.2f%n", journey.type(), journey.fare());
            }
            System.out.printf("Total: %.2f%n", total);
        }
    }
}