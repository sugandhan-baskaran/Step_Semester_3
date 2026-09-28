package week8.assignment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryFee {
    private interface Delivery {
        double fee();
        String type();
    }

    private record Standard(double weight, double distance) implements Delivery {
        @Override
        public double fee() { return 5 + 0.5 * weight + 0.1 * distance; }
        @Override
        public String type() { return "STANDARD"; }
    }

    private record Express(double weight, double distance) implements Delivery {
        @Override
        public double fee() { return 15 + weight + 0.2 * distance; }
        @Override
        public String type() { return "EXPRESS"; }
    }

    private record International(double weight, double distance, double customsFee) implements Delivery {
        @Override
        public double fee() { return 25 + 2 * weight + 0.5 * distance + customsFee; }
        @Override
        public String type() { return "INTERNATIONAL"; }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int count = scanner.nextInt();
            List<Delivery> deliveries = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                String type = scanner.next();
                double weight = scanner.nextDouble();
                double distance = scanner.nextDouble();
                deliveries.add(type.equals("STANDARD") ? new Standard(weight, distance)
                        : type.equals("EXPRESS") ? new Express(weight, distance)
                        : new International(weight, distance, scanner.nextDouble()));
            }
            double total = 0;
            for (Delivery delivery : deliveries) {
                total += delivery.fee();
                System.out.printf("%s: %.2f%n", delivery.type(), delivery.fee());
            }
            System.out.printf("Total: %.2f%n", total);
        }
    }
}