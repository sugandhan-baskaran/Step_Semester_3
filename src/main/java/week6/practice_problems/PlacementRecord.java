package week6.practice_problems;
import java.util.Scanner;

public class PlacementRecord {
    String studentName;
    String company;
    double packageLpa;

    public PlacementRecord(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    public void printRecord() {
        System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("=== Placement Record Manager ===");
            System.out.print("Enter number of placement records: ");
            int n = sc.nextInt();
            sc.nextLine(); // consume newline
            
            PlacementRecord[] records = new PlacementRecord[n];
            
            for (int i = 0; i < n; i++) {
                System.out.print("\nPlacement Record " + (i+1) + ":");
                System.out.print("\nEnter student name: ");
                String studentName = sc.nextLine();
                System.out.print("Enter company name: ");
                String company = sc.nextLine();
                System.out.print("Enter package (LPA): ");
                double packageLpa = sc.nextDouble();
                sc.nextLine(); // consume newline
                
                records[i] = new PlacementRecord(studentName, company, packageLpa);
            }
            
            System.out.println("\n=== Placement Records ===");
            for (PlacementRecord record : records) {
                record.printRecord();
            }
        }
    }
}
