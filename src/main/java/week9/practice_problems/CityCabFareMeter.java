package week9.practice_problems;

import java.util.Scanner;

public class CityCabFareMeter {
    interface NightService {
        double nightFare(double fare);
    }

    static abstract class Cab {
        private static final double MINIMUM_FARE = 100;
        private final double distance;

        Cab(double distance) {
            this.distance = distance;
        }

        abstract double rate();

        double dayFare() {
            return Math.max(distance * rate(), MINIMUM_FARE);
        }

        double distance() {
            return distance;
        }
    }

    static class Mini extends Cab {
        Mini(double distance) {
            super(distance);
        }

        @Override
        double rate() {
            return 10;
        }
    }

    static class Sedan extends Cab implements NightService {
        Sedan(double distance) {
            super(distance);
        }

        @Override
        double rate() {
            return 14;
        }

        @Override
        public double nightFare(double fare) {
            return fare * 1.2;
        }
    }

    static class Suv extends Cab implements NightService {
        Suv(double distance) {
            super(distance);
        }

        @Override
        double rate() {
            return 18;
        }

        @Override
        public double nightFare(double fare) {
            return fare * 1.2;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of trips: ");
        int count = scanner.nextInt();
        double total = 0;

        for (int i = 0; i < count; i++) {
            System.out.print("Enter cab type, distance in km, and time: ");
            String type = scanner.next();
            double distance = scanner.nextDouble();
            String time = scanner.next();
            Cab cab;
            if (type.equals("MINI")) {
                cab = new Mini(distance);
            } else if (type.equals("SEDAN")) {
                cab = new Sedan(distance);
            } else {
                cab = new Suv(distance);
            }
            if (time.equals("NIGHT") && !(cab instanceof NightService)) {
                System.out.println(type + ": night service not available");
                continue;
            }
            double fare = cab.dayFare();
            if (time.equals("NIGHT")) {
                fare = ((NightService) cab).nightFare(fare);
            }
            total += fare;
            System.out.printf("%s: %.2f%n", type, fare);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
