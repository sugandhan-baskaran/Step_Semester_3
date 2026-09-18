package week6.practice_problems;
import java.util.Scanner;

public class Course {
    String code;
    String title;
    int credits;
    int labCredits;

    public Course(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    public Course(String code, String title, int credits) {
        this(code, title, credits, 0); // chains to 4-arg constructor
    }

    public int totalCredits() {
        return credits + labCredits;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("=== Course Manager ===");
            System.out.print("Enter number of courses: ");
            int n = sc.nextInt();
            sc.nextLine(); // consume newline
            
            for (int i = 0; i < n; i++) {
                System.out.print("\nCourse " + (i+1) + ":");
                System.out.print("\nEnter course code: ");
                String code = sc.nextLine();
                System.out.print("Enter course title: ");
                String title = sc.nextLine();
                System.out.print("Enter credits: ");
                int credits = sc.nextInt();
                System.out.print("Enter lab credits (0 if none): ");
                int labCredits = sc.nextInt();
                sc.nextLine(); // consume newline
                
                Course course;
                if (labCredits == 0) {
                    course = new Course(code, title, credits);
                } else {
                    course = new Course(code, title, credits, labCredits);
                }
                
                System.out.println(code + " total credits: " + course.totalCredits());
            }
        }
    }
}
