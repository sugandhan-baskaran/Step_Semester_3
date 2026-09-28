package week8.practice_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FestivalBonus {
    private interface Employee {
        double bonus();
        String name();
    }

    private record FullTime(String name, double salary) implements Employee {
        @Override
        public double bonus() { return salary * 0.10; }
    }

    private record PartTime(String name, double salary) implements Employee {
        @Override
        public double bonus() { return salary * 0.05; }
    }

    private record Intern(String name, double salary) implements Employee {
        @Override
        public double bonus() { return 2000; }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int count = scanner.nextInt();
            List<Employee> employees = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                String type = scanner.next();
                String name = scanner.next();
                double salary = scanner.nextDouble();
                employees.add(type.equals("FULLTIME") ? new FullTime(name, salary)
                        : type.equals("PARTTIME") ? new PartTime(name, salary) : new Intern(name, salary));
            }
            double total = 0;
            for (Employee employee : employees) {
                total += employee.bonus();
                System.out.printf("%s: %.2f%n", employee.name(), employee.bonus());
            }
            System.out.printf("Total Bonus: %.2f%n", total);
        }
    }
}