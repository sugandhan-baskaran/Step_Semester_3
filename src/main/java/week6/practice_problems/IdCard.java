package week6.practice_problems;
import java.util.Scanner;

public class IdCard {
    String name;
    int booksIssued;

    public IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("=== ID Card Manager ===");
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            System.out.print("Enter initial books issued: ");
            int booksIssued = sc.nextInt();
            sc.nextLine(); // consume newline
            
            IdCard student = new IdCard(name, booksIssued);
            IdCard duplicate = student;
            
            System.out.print("Enter new books count for duplicate: ");
            duplicate.booksIssued = sc.nextInt();

            System.out.println("\nStudent's booksIssued (via first variable): " + student.booksIssued);
            System.out.println("duplicate == student: " + (duplicate == student));

            System.out.print("Enter separate student name: ");
            sc.nextLine(); // consume newline
            String sepName = sc.nextLine();
            System.out.print("Enter separate student books issued: ");
            int sepBooks = sc.nextInt();
            
            IdCard separate = new IdCard(sepName, sepBooks);
            System.out.println("separate == student: " + (separate == student));
        }
    }
}