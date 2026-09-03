package LEVEL_2;
import java.util.Scanner;
public class GradeClassifier {
    public void classifyWithAttendance(int marks, int attendance) {
        if (attendance >= 75 && marks >= 40) {
            if (marks >= 90) {
                System.out.println("Grade: A");
            } else if (marks >= 75) {
                System.out.println("Grade: B");
            } else if (marks >= 50) {
                System.out.println("Grade: C");
            } else if (marks >= 40) {
                System.out.println("Grade: D");
            }
        } else {
            System.out.println("Detained");
        }
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter marks and attendance percentage:");
            int marks = sc.nextInt();
            System.out.println("Enter attendance percentage:");
            int attendance = sc.nextInt();

            GradeClassifier classifier = new GradeClassifier();
            classifier.classifyWithAttendance(marks, attendance);
        }
    }
}