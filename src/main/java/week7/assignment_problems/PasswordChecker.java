package week7.assignment_problems;

import java.util.Scanner;

public class PasswordChecker {
    private final String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        if (password.length() < 6) {
            return "Weak";
        }
        if (password.length() < 10) {
            return "Medium";
        }
        return "Strong";
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter password: ");
            PasswordChecker passwordChecker = new PasswordChecker(scanner.nextLine());
            System.out.println("Strength: " + passwordChecker.getStrength());
        }
    }
}
