package LEVEL_2;

import java.util.Scanner;

public class PrimeChecker {
    public void checkPrime(int number) {
        boolean isPrime = true;
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime && number > 1) {
            System.out.println("Prime");
        } else {
            System.out.println("Not Prime");
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter a number: ");
            int number = sc.nextInt();
            PrimeChecker checker = new PrimeChecker();
            checker.checkPrime(number);
        }
    }
}