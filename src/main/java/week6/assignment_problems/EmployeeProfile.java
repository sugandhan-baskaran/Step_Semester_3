package week6.assignment_problems;
import java.util.Scanner;

public class EmployeeProfile {
    String empId;
    String empName;
    double salary;
    boolean isIntern;

    public EmployeeProfile(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    public EmployeeProfile(String empId, String empName) {
        this(empId, empName, 0.0);
        this.isIntern = true;
    }

    public void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("=== Employee Profile Manager ===");
            System.out.print("Enter number of employees: ");
            int n = sc.nextInt();
            sc.nextLine(); // consume newline
            
            for (int i = 0; i < n; i++) {
                System.out.print("\nEmployee " + (i+1) + ":");
                System.out.print("\nEnter Employee ID: ");
                String empId = sc.nextLine();
                System.out.print("Enter Employee Name: ");
                String empName = sc.nextLine();
                System.out.print("Is intern? (true/false): ");
                boolean isIntern = sc.nextBoolean();
                sc.nextLine(); // consume newline
                
                EmployeeProfile emp;
                if (isIntern) {
                    emp = new EmployeeProfile(empId, empName);
                } else {
                    System.out.print("Enter salary: ");
                    double salary = sc.nextDouble();
                    sc.nextLine(); // consume newline
                    emp = new EmployeeProfile(empId, empName, salary);
                }
                
                emp.printProfile();
            }
        }
    }
}