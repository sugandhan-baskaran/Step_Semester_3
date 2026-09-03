package LEVEL_2;

import java.util.Scanner;

public class LoginSimulator {
    public void simulateLogin(String correctCode, String[] attempts) {
        boolean granted = false;
        for (int i = 0; i < attempts.length; i++) {
            if (attempts[i].equals(correctCode)) {
                System.out.println("Access granted on attempt " + (i + 1));
                granted = true;
                break;
            }
        }
        if (!granted) {
            System.out.println("Access denied all attempts used");
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the correct code: ");
            String correctCode = sc.next();
            System.out.print("Enter number of attempts: ");
            int numAttempts = sc.nextInt();
            String[] attempts = new String[numAttempts];

            for (int i = 0; i < numAttempts; i++) {
                System.out.print("Enter attempt " + (i + 1) + ": ");
                attempts[i] = sc.next();
            }
            LoginSimulator simulator = new LoginSimulator();
            simulator.simulateLogin(correctCode, attempts);
        }
    }
}