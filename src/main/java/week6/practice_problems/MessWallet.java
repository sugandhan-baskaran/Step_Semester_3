package week6.practice_problems;
import java.util.Scanner;

public class MessWallet {
    private double balance;

    public MessWallet(double openingBalance) {
        if (openingBalance < 0) {
            System.out.println("Warning: Opening balance cannot be negative. Setting to 0.");
            this.balance = 0;
        } else {
            this.balance = openingBalance;
        }
    }

    public void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Top-up rejected: Amount must be greater than 0");
        } else {
            this.balance += amount;
            System.out.println("Balance after top-up: " + this.balance);
        }
    }

    public void deduct(double amount) {
        if (amount > this.balance) {
            System.out.println("Deduct rejected: insufficient balance");
        } else {
            this.balance -= amount;
            System.out.println("Amount deducted. Current balance: " + this.balance);
        }
    }

    public double getBalance() {
        return this.balance;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("=== Mess Wallet Manager ===");
            System.out.print("Enter opening balance: ");
            double openingBalance = sc.nextDouble();
            
            MessWallet wallet = new MessWallet(openingBalance);
            
            System.out.print("Enter top-up amount: ");
            double topUpAmount = sc.nextDouble();
            wallet.topUp(topUpAmount);
            
            System.out.print("Enter amount to deduct: ");
            double deductAmount = sc.nextDouble();
            wallet.deduct(deductAmount);
            
            System.out.println("Final balance: " + wallet.getBalance());
        }
    }
}
