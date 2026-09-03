package main.java.week2.practice_problems;

import java.util.Scanner;

public class BankTransactionValidator {
    public static String normalizeReference(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() >= 3) {
            return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
        }
        return trimmed.toUpperCase();
    }

    public static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: body must be digits";
            }
        }

        String bankCode = reference.substring(0, 3);
        String dateDD = reference.substring(3, 5);
        String dateMM = reference.substring(5, 7);
        String dateYY = reference.substring(7, 9);
        String seq = reference.substring(9);

        StringBuilder formatted = new StringBuilder();
        formatted.append("[").append(bankCode).append("] ");
        formatted.append("DATE: ").append(dateDD).append("/").append(dateMM).append("/").append(dateYY).append(" | ");
        formatted.append("SEQ: ").append(seq);

        return formatted.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter transaction reference: ");
        String input = scanner.nextLine();
        
        String normalized = normalizeReference(input);
        String result = validateAndFormat(normalized);
        System.out.println(result);
        
        scanner.close();
    }
}
