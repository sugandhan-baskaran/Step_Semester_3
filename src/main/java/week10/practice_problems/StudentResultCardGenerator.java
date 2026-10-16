package week10.practice_problems;

import java.util.Locale;
import java.util.Scanner;

public class StudentResultCardGenerator {
    private static class Student {
        private final String name;
        private final int[] marks;

        private Student(String name, int[] marks) {
            this.name = name;
            this.marks = marks;
        }

        private double average() {
            int total = 0;
            for (int mark : marks) {
                total += mark;
            }
            return total / (double) marks.length;
        }

        private char grade() {
            double average = average();
            if (average >= 75) return 'B';
            if (average >= 60) return 'C';
            if (average >= 40) return 'D';
            return 'F';
        }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNext()) {
                String name = scanner.next();
                int[] marks = {scanner.nextInt(), scanner.nextInt(), scanner.nextInt()};
                Student student = new Student(name, marks);
                System.out.printf("%s: Average %.1f, Grade %c%n",
                        student.name.toUpperCase(Locale.ROOT), student.average(), student.grade());
            }
        }
    }
}