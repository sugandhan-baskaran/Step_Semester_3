package week7.practice_problems;

import java.util.Scanner;

public class AttendanceSheet {
    private final String[] presentStudents;
    private int presentCount;

    public AttendanceSheet(int maximumClassSize) {
        presentStudents = new String[maximumClassSize];
    }

    public void markPresent(String name) {
        if (isPresent(name) || presentCount >= presentStudents.length) {
            return;
        }
        presentStudents[presentCount] = name;
        presentCount++;
    }

    public int getPresentCount() {
        return presentCount;
    }

    public boolean isPresent(String name) {
        for (int i = 0; i < presentCount; i++) {
            if (presentStudents[i].equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter maximum class size: ");
            AttendanceSheet sheet = new AttendanceSheet(scanner.nextInt());
            System.out.print("Enter number of students to mark present: ");
            int numberOfStudents = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < numberOfStudents; i++) {
                System.out.print("Enter student name: ");
                sheet.markPresent(scanner.nextLine());
            }
            System.out.print("Enter name to check: ");
            String name = scanner.nextLine();
        System.out.println("Present count: " + sheet.getPresentCount());
            System.out.println(name + " present: " + sheet.isPresent(name));
        }
    }
}
