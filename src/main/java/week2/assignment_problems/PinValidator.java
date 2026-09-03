package main.java.week2.assignment_problems;
import java.util.Scanner;

public class PinValidator {
    public static void checkPinLength(String pin) {
        if (pin.length() == 4) {
            System.out.println("PIN length OK.");
        } else {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the 4 digit ATM PIN:");
        String userInput = sc.nextLine();
        checkPinLength(userInput);
        sc.close();
    }
}