package week6.assignment_problems;
import java.util.Scanner;

public class Student {
    String name;
    int attendance;
    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    public Student(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    public static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students on record: " + studentCount);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("=== Student Registration ===");
            System.out.print("Enter number of students: ");
            int n = sc.nextInt();
            sc.nextLine(); // consume newline
            
            for (int i = 0; i < n; i++) {
                System.out.print("Enter student " + (i+1) + " name: ");
                String name = sc.nextLine();
                System.out.print("Enter student " + (i+1) + " attendance: ");
                int attendance = sc.nextInt();
                sc.nextLine(); // consume newline
                
                new Student(name, attendance);
            }

            System.out.println("\n" + Student.studentCount + " Student objects created\n");
            Student.printCollegeInfo();
        }
    }
}