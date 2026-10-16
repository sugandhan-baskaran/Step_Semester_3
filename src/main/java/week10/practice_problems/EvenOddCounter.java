package week10.practice_problems;

import java.util.Scanner;

public class EvenOddCounter {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int count = scanner.nextInt();
            int even = 0;
            for (int index = 0; index < count; index++) {
                if (scanner.nextInt() % 2 == 0) {
                    even++;
                }
            }
            System.out.println("Even: " + even);
            System.out.println("Odd: " + (count - even));
        }
    }
}