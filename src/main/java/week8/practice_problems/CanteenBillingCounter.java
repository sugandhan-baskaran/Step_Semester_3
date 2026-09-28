package week8.practice_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CanteenBillingCounter {
    private interface Bill {
        double finalAmount();
        String type();
    }

    private record Student(double amount) implements Bill {
        @Override
        public double finalAmount() { return amount * 0.9; }
        @Override
        public String type() { return "STUDENT"; }
    }

    private record Staff(double amount) implements Bill {
        @Override
        public double finalAmount() { return amount * 0.95; }
        @Override
        public String type() { return "STAFF"; }
    }

    private record Guest(double amount) implements Bill {
        @Override
        public double finalAmount() { return amount + 10; }
        @Override
        public String type() { return "GUEST"; }
    }

    private static Bill createBill(String type, double amount) {
        return switch (type) {
            case "STUDENT" -> new Student(amount);
            case "STAFF" -> new Staff(amount);
            default -> new Guest(amount);
        };
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int count = scanner.nextInt();
            List<Bill> bills = new ArrayList<>();
            for (int i = 0; i < count; i++) bills.add(createBill(scanner.next(), scanner.nextDouble()));
            double total = 0;
            for (Bill bill : bills) {
                total += bill.finalAmount();
                System.out.printf("%s: %.2f%n", bill.type(), bill.finalAmount());
            }
            System.out.printf("Total: %.2f%n", total);
        }
    }
}