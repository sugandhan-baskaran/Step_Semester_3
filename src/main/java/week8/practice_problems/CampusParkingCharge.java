package week8.practice_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CampusParkingCharge {
    private interface Vehicle {
        double charge();
        String type();
    }

    private record Bike(int hours) implements Vehicle {
        @Override
        public double charge() { return hours * 10.0; }
        @Override
        public String type() { return "BIKE"; }
    }

    private record Car(int hours) implements Vehicle {
        @Override
        public double charge() { return 30 + Math.max(0, hours - 1) * 20.0; }
        @Override
        public String type() { return "CAR"; }
    }

    private record Truck(int hours) implements Vehicle {
        @Override
        public double charge() { return Math.max(100, hours * 50.0); }
        @Override
        public String type() { return "TRUCK"; }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int count = scanner.nextInt();
            List<Vehicle> vehicles = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                String type = scanner.next();
                int hours = scanner.nextInt();
                vehicles.add(type.equals("BIKE") ? new Bike(hours)
                        : type.equals("CAR") ? new Car(hours) : new Truck(hours));
            }
            double total = 0;
            for (Vehicle vehicle : vehicles) {
                total += vehicle.charge();
                System.out.printf("%s: %.2f%n", vehicle.type(), vehicle.charge());
            }
            System.out.printf("Total: %.2f%n", total);
        }
    }
}