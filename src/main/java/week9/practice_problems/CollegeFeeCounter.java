package week9.practice_problems;

import java.util.Scanner;

public class CollegeFeeCounter {
    static abstract class Student {
        private static final double TRANSPORT_FEE = 12000;
        private final String name;

        Student(String name) {
            this.name = name;
        }

        abstract double tuition();

        abstract boolean usesBus();

        double fee() {
            return tuition() + (usesBus() ? TRANSPORT_FEE : 0);
        }

        String name() {
            return name;
        }
    }

    static class DayScholar extends Student {
        DayScholar(String name) {
            super(name);
        }

        @Override
        double tuition() {
            return 40000;
        }

        @Override
        boolean usesBus() {
            return true;
        }
    }

    static class Hosteller extends Student {
        Hosteller(String name) {
            super(name);
        }

        @Override
        double tuition() {
            return 100000;
        }

        @Override
        boolean usesBus() {
            return false;
        }
    }

    static class Scholar extends Student {
        Scholar(String name) {
            super(name);
        }

        @Override
        double tuition() {
            return 20000;
        }

        @Override
        boolean usesBus() {
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int count = scanner.nextInt();
        double total = 0;

        for (int i = 0; i < count; i++) {
            System.out.print("Enter student type and name: ");
            String type = scanner.next();
            String name = scanner.next();
            Student student;
            if (type.equals("DAY_SCHOLAR")) {
                student = new DayScholar(name);
            } else if (type.equals("HOSTELLER")) {
                student = new Hosteller(name);
            } else {
                student = new Scholar(name);
            }
            double fee = student.fee();
            total += fee;
            System.out.printf("%s: %.2f%n", student.name(), fee);
        }
        System.out.printf("Total Collected: %.2f%n", total);
    }
}
