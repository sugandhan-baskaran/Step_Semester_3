package LEVEL_1;

import java.util.Scanner;

public class SumOfNaturalNumbers {
    public void sumOfNaturalNumbers(int n) {
        int sum = 0;
        int counter = 1;
        while (counter <= n) {
            sum += counter;
            counter++;
        }
        System.out.println("Sum of numbers from 1 to " + n + " = " + sum);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter a number: ");
            int n = sc.nextInt();

            SumOfNaturalNumbers calculator = new SumOfNaturalNumbers();
            calculator.sumOfNaturalNumbers(n);
        }
    }
}