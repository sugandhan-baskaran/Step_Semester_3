package week11.practice_problems;

public class LibraryCatalogLookup {
    static class Book {
        String isbn;
        String title;

        Book(String isbn, String title) {
            this.isbn = isbn;
            this.title = title;
        }
    }

    public static String findBook(Book[] catalog, String targetIsbn) {
        int low = 0, high = catalog.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = catalog[mid].isbn.compareTo(targetIsbn);

            if (comparison == 0) return catalog[mid].title;
            if (comparison < 0) low = mid + 1;
            else high = mid - 1;
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        Book[] catalog = {
            new Book("0001112223", "Introduction to Algebra"),
            new Book("0002223334", "Beginning Python"),
            new Book("0003334445", "Classic Mythology"),
            new Book("0004445556", "Data and Society"),
            new Book("0005556667", "European History")
        };

        System.out.println(findBook(catalog, "0003334445"));
        System.out.println(findBook(catalog, "0009998887"));
        System.out.println(findBook(catalog, "0001112223"));
    }
}
