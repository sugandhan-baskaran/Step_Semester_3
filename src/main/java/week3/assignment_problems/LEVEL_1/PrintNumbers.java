package LEVEL_1;

import java.util.Scanner;

public class PrintNumbers {
    public void printNumbersUpToN(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter a number: ");
            int n = sc.nextInt();
            PrintNumbers printer = new PrintNumbers();
            printer.printNumbersUpToN(n);
        }
    }
}