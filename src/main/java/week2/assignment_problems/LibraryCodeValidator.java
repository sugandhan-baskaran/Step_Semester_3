package main.java.week2.assignment_problems;

import java.util.Scanner;

public class LibraryCodeValidator {
    public static String normalizeCode(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }
    public static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: non-letter publisher code";
            }
        }
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }
        StringBuilder formattedString = new StringBuilder();
        formattedString.append("[")
                       .append(code.substring(0, 3))
                       .append("] YEAR: ")
                       .append(code.substring(3, 7))
                       .append(" | CATALOG: ")
                       .append(code.substring(7));

        return formattedString.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a library code:");
        String rawInput = sc.nextLine();
        String normalized = normalizeCode(rawInput);
        String result = validateAndFormat(normalized);
        System.out.println(result);
        sc.close();
    }
}