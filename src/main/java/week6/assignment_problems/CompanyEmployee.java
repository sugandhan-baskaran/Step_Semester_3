package week6.assignment_problems;
import java.util.Scanner;

public class CompanyEmployee {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public CompanyEmployee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("=== Company Employee Registration ===");
            System.out.print("Enter number of employees: ");
            int n = sc.nextInt();
            sc.nextLine(); // consume newline
            
            for (int i = 0; i < n; i++) {
                System.out.print("Enter employee " + (i+1) + " name: ");
                String name = sc.nextLine();
                System.out.print("Enter employee " + (i+1) + " salary: ");
                double salary = sc.nextDouble();
                sc.nextLine(); // consume newline
                
                new CompanyEmployee(name, salary);
            }

            System.out.println("\n" + CompanyEmployee.employeeCount + " Employee objects created\n");
            CompanyEmployee.printCompanyInfo();
        }
    }
}
