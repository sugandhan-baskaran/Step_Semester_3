package week6.assignment_problems;
import java.util.Scanner;

public class PayrollAccount {
    private double basicSalary;
    private double bonus;

    public PayrollAccount(double basicSalary) {
        if (basicSalary < 0) {
            System.out.println("Warning: Basic salary cannot be negative. Setting to 0.");
            this.basicSalary = 0;
        } else {
            this.basicSalary = basicSalary;
        }
        this.bonus = 0;
    }

    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Bonus rejected: Amount must be greater than 0");
        } else {
            this.bonus += amount;
            System.out.println("Bonus credited: Rs " + amount);
        }
    }

    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Tax deduction rejected: Percentage must be between 0 and 100");
        } else {
            this.basicSalary -= (this.basicSalary * (percent / 100));
            System.out.println("Tax deducted: " + (int)percent + "%");
        }
    }

    public double getNetSalary() {
        return this.basicSalary + this.bonus;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("=== Payroll Account Manager ===");
            System.out.print("Enter basic salary: ");
            double basicSalary = sc.nextDouble();
            
            PayrollAccount account = new PayrollAccount(basicSalary);
            
            System.out.print("Enter bonus amount: ");
            double bonusAmount = sc.nextDouble();
            account.creditBonus(bonusAmount);
            
            System.out.print("Enter tax percentage: ");
            double taxPercent = sc.nextDouble();
            account.deductTax(taxPercent);
            
            System.out.println("Net salary: Rs " + account.getNetSalary());
        }
    }
}
