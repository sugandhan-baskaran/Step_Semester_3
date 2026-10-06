package week9.assignment_problems;

import java.util.Scanner;

public class WeeklyStaffPay {
    static abstract class StaffMember {
        private final String name;

        StaffMember(String name) {
            this.name = name;
        }

        abstract double pay();

        String name() {
            return name;
        }
    }

    static class FullTime extends StaffMember {
        private final double salary;

        FullTime(String name, double salary) {
            super(name);
            this.salary = salary;
        }

        @Override
        double pay() {
            return salary;
        }
    }

    static class Hourly extends StaffMember {
        private final double hours;
        private final double rate;

        Hourly(String name, double hours, double rate) {
            super(name);
            this.hours = hours;
            this.rate = rate;
        }

        @Override
        double pay() {
            return hours <= 40 ? hours * rate : 40 * rate + (hours - 40) * rate * 1.5;
        }
    }

    static class Intern extends StaffMember {
        private final double stipend;

        Intern(String name, double stipend) {
            super(name);
            this.stipend = stipend;
        }

        @Override
        double pay() {
            return stipend;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of staff members: ");
        int count = scanner.nextInt();
        double total = 0;

        for (int i = 0; i < count; i++) {
            System.out.print("Enter staff type, name, and pay details: ");
            String type = scanner.next();
            String name = scanner.next();
            StaffMember staff;
            if (type.equals("FULLTIME")) {
                staff = new FullTime(name, scanner.nextDouble());
            } else if (type.equals("HOURLY")) {
                staff = new Hourly(name, scanner.nextDouble(), scanner.nextDouble());
            } else {
                staff = new Intern(name, scanner.nextDouble());
            }
            double pay = staff.pay();
            total += pay;
            System.out.printf("%s: %.2f%n", staff.name(), pay);
        }
        System.out.printf("Total Payroll: %.2f%n", total);
    }
}
