package week9.practice_problems;

import java.util.Scanner;

public class MovieTicketCounter {
    static abstract class Ticket {
        private static final double CONVENIENCE_FEE = 20;
        private final int count;

        Ticket(int count) {
            this.count = count;
        }

        abstract double price();

        double amount() {
            return count * (price() + CONVENIENCE_FEE);
        }
    }

    static class Regular extends Ticket {
        Regular(int count) {
            super(count);
        }

        @Override
        double price() {
            return 150;
        }
    }

    static class Premium extends Ticket {
        Premium(int count) {
            super(count);
        }

        @Override
        double price() {
            return 250;
        }
    }

    static class Recliner extends Ticket {
        Recliner(int count) {
            super(count);
        }

        @Override
        double price() {
            return 400;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of bookings: ");
        int bookings = scanner.nextInt();
        double total = 0;

        for (int i = 0; i < bookings; i++) {
            System.out.print("Enter seat type and ticket count: ");
            String seat = scanner.next();
            int count = scanner.nextInt();
            Ticket ticket;
            if (seat.equals("REGULAR")) {
                ticket = new Regular(count);
            } else if (seat.equals("PREMIUM")) {
                ticket = new Premium(count);
            } else {
                ticket = new Recliner(count);
            }
            double amount = ticket.amount();
            total += amount;
            System.out.printf("%s: %.2f%n", seat, amount);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
