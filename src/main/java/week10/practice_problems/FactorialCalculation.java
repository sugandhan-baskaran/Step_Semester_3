package week10.practice_problems;

import java.util.Scanner;

public class FactorialCalculation {
    public static long factorial(int number) {
        long result = 1;
        for (int value = 2; value <= number; value++) {
            result *= value;
        }
        return result;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(factorial(scanner.nextInt()));
        }
    }
}