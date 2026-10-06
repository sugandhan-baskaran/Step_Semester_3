package week9.assignment_problems;

import java.util.Scanner;

public class LibraryLateFineCounter {
    static abstract class LibraryItem {
        private final String title;
        private final int daysLate;

        LibraryItem(String title, int daysLate) {
            this.title = title;
            this.daysLate = daysLate;
        }

        abstract double fine();

        String title() {
            return title;
        }

        int daysLate() {
            return daysLate;
        }
    }

    static class Book extends LibraryItem {
        Book(String title, int daysLate) {
            super(title, daysLate);
        }

        @Override
        double fine() {
            return daysLate() * 2;
        }
    }

    static class Dvd extends LibraryItem {
        Dvd(String title, int daysLate) {
            super(title, daysLate);
        }

        @Override
        double fine() {
            return Math.min(daysLate() * 5, 50);
        }
    }

    static class Magazine extends LibraryItem {
        Magazine(String title, int daysLate) {
            super(title, daysLate);
        }

        @Override
        double fine() {
            return daysLate();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of library items: ");
        int count = scanner.nextInt();
        double total = 0;

        for (int i = 0; i < count; i++) {
            System.out.print("Enter item type, title, and days late: ");
            String type = scanner.next();
            String title = scanner.next();
            int daysLate = scanner.nextInt();
            LibraryItem item;
            if (type.equals("BOOK")) {
                item = new Book(title, daysLate);
            } else if (type.equals("DVD")) {
                item = new Dvd(title, daysLate);
            } else {
                item = new Magazine(title, daysLate);
            }
            double fine = item.fine();
            total += fine;
            System.out.printf("%s: %.2f%n", item.title(), fine);
        }
        System.out.printf("Total Fines: %.2f%n", total);
    }
}
