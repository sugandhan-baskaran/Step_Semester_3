package week11.assignment_problems;

import java.util.Arrays;

public class LibraryBookShelf {
    public static void shelf(int[] books) {
        for (int i = 1; i < books.length; i++) {
            int current = books[i];
            int j = i - 1;

            while (j >= 0 && books[j] > current) {
                books[j + 1] = books[j];
                j--;
            }

            books[j + 1] = current;
            System.out.println("After placing " + current + ": " +
                    Arrays.toString(books));
        }
    }

    public static void main(String[] args) {
        shelf(new int[]{30, 10, 40, 20});
        System.out.println();
        shelf(new int[]{8, 3, 6, 1, 5});
    }
}
