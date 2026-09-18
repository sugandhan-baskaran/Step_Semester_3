package week6.assignment_problems;
import java.util.Scanner;

public class HallTicket {
    String studentName;
    int seatNumber;

    public HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("=== Hall Ticket Manager ===");
            System.out.print("Enter student name: ");
            String studentName = sc.nextLine();
            System.out.print("Enter initial seat number: ");
            int seatNumber = sc.nextInt();
            sc.nextLine(); // consume newline
            
            HallTicket student = new HallTicket(studentName, seatNumber);
            HallTicket copy = student;
            
            System.out.print("Enter new seat number for copy: ");
            copy.seatNumber = sc.nextInt();

            System.out.println("\nStudent's seatNumber (via first variable): " + student.seatNumber);
            System.out.println("copy == student: " + (copy == student));

            System.out.print("Enter separate student name: ");
            sc.nextLine(); // consume newline
            String sepName = sc.nextLine();
            System.out.print("Enter separate student seat number: ");
            int sepSeat = sc.nextInt();
            
            HallTicket separate = new HallTicket(sepName, sepSeat);
            System.out.println("separate == student: " + (separate == student));
        }
    }
}