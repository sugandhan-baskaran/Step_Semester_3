package week8.assignment_problems;

import java.time.LocalDate;
import java.util.Scanner;

public class LibraryItemDueDate {
    private interface LibraryItem {
        String title();
        LocalDate dueDate();
    }

    private abstract static class BorrowedItem implements LibraryItem {
        private final String title;
        BorrowedItem(String title) { this.title = title; }
        @Override
        public String title() { return title; }
        @Override
        public LocalDate dueDate() { return LocalDate.of(2023, 10, 26).plusDays(borrowingDays()); }
        protected abstract int borrowingDays();
    }

    private static class Book extends BorrowedItem {
        Book(String title) { super(title); }
        @Override
        protected int borrowingDays() { return 14; }
    }

    private static class Dvd extends BorrowedItem {
        Dvd(String title) { super(title); }
        @Override
        protected int borrowingDays() { return 7; }
    }

    private static class Magazine extends BorrowedItem {
        Magazine(String title) { super(title); }
        @Override
        protected int borrowingDays() { return 3; }
    }

    private static LibraryItem createItem(String type, String title) {
        return switch (type) {
            case "BOOK" -> new Book(title);
            case "DVD" -> new Dvd(title);
            default -> new Magazine(title);
        };
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int count = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < count; i++) {
                String line = scanner.nextLine().trim();
                int separator = line.indexOf(' ');
                String type = line.substring(0, separator);
                String title = line.substring(separator + 1).replaceAll("^\"|\"$", "");
                LibraryItem item = createItem(type, title);
                System.out.println(item.title() + ": " + item.dueDate());
            }
        }
    }
}