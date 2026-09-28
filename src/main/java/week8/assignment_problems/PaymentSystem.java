package week8.assignment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaymentSystem {
    private interface Payment {
        double adjustedAmount();
        String type();
    }

    private static class Card implements Payment {
        private final double amount;
        Card(double amount) { this.amount = amount; }
        @Override
        public double adjustedAmount() { return amount * 1.02; }
        @Override
        public String type() { return "CARD"; }
    }

    private static class Wallet implements Payment {
        private final double amount;
        Wallet(double amount) { this.amount = amount; }
        @Override
        public double adjustedAmount() { return amount * 1.01; }
        @Override
        public String type() { return "WALLET"; }
    }

    private static class BankTransfer implements Payment {
        private final double amount;
        BankTransfer(double amount) { this.amount = amount; }
        @Override
        public double adjustedAmount() { return amount; }
        @Override
        public String type() { return "BANKTRANSFER"; }
    }

    private static Payment createPayment(String type, double amount) {
        return switch (type) {
            case "CARD" -> new Card(amount);
            case "WALLET" -> new Wallet(amount);
            default -> new BankTransfer(amount);
        };
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int count = scanner.nextInt();
            List<Payment> payments = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                payments.add(createPayment(scanner.next(), scanner.nextDouble()));
            }
            double total = 0;
            for (Payment payment : payments) {
                double adjustedAmount = payment.adjustedAmount();
                total += adjustedAmount;
                System.out.printf("%s: %.2f%n", payment.type(), adjustedAmount);
            }
            System.out.printf("Total: %.2f%n", total);
        }
    }
}