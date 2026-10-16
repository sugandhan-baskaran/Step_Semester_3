package week10.practice_problems;

import java.util.Scanner;

public class LeapYearDetector {
    public static boolean isLeapYear(int year) {
        return year % 400 == 0 || year % 4 == 0 && year % 100 != 0;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextInt()) {
                System.out.println(isLeapYear(scanner.nextInt()) ? "Leap year" : "Not a leap year");
            }
        }
    }
}