package week7.practice_problems;

import java.util.Scanner;

public class PiggyBank {
    private final String id;
    private int savings;

    public PiggyBank(String id) {
        this.id = id;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            savings += amount;
        }
    }

    public void withdraw(int amount) {
        if (amount > 0 && amount <= savings) {
            savings -= amount;
        }
    }

    public int getSavings() {
        return savings;
    }

    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter piggy bank ID: ");
            PiggyBank piggyBank = new PiggyBank(scanner.nextLine());
            System.out.print("Enter deposit amount: ");
            piggyBank.deposit(scanner.nextInt());
            System.out.println("Savings: " + piggyBank.getSavings());
            System.out.print("Enter withdrawal amount: ");
            piggyBank.withdraw(scanner.nextInt());
            System.out.println("Savings: " + piggyBank.getSavings());
        }
    }
}
