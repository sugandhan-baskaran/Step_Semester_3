package week9.assignment_problems;

import java.util.Scanner;

public class TravelBookingWithCommonFee {
    static abstract class Booking {
        private static final double BOOKING_FEE = 50;
        private final double distance;

        Booking(double distance) {
            this.distance = distance;
        }

        abstract double baseFare();

        double totalFare() {
            return baseFare() + BOOKING_FEE;
        }

        double distance() {
            return distance;
        }
    }

    static class Bus extends Booking {
        Bus(double distance) {
            super(distance);
        }

        @Override
        double baseFare() {
            return distance() * 2;
        }
    }

    static class Train extends Booking {
        Train(double distance) {
            super(distance);
        }

        @Override
        double baseFare() {
            return distance() * 1.5;
        }
    }

    static class Flight extends Booking {
        Flight(double distance) {
            super(distance);
        }

        @Override
        double baseFare() {
            return 2500 + distance() * 4;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of bookings: ");
        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            System.out.print("Enter travel mode and distance in km: ");
            String mode = scanner.next();
            Booking booking;
            double distance = scanner.nextDouble();
            if (mode.equals("BUS")) {
                booking = new Bus(distance);
            } else if (mode.equals("TRAIN")) {
                booking = new Train(distance);
            } else {
                booking = new Flight(distance);
            }
            System.out.printf("%s: %.2f%n", mode, booking.totalFare());
        }
    }
}
