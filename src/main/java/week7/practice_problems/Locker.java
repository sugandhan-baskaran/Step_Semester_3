package week7.practice_problems;

import java.util.Scanner;

public class Locker {
    private final int lockerNumber;
    private String code;

    public Locker(int lockerNumber, String code) {
        this.lockerNumber = lockerNumber;
        this.code = code;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (code.equals(currentCode)) {
            code = newCode;
            return true;
        }
        return false;
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter locker number: ");
            int lockerNumber = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter initial code: ");
            Locker locker = new Locker(lockerNumber, scanner.nextLine());
            System.out.print("Enter current code: ");
            String currentCode = scanner.nextLine();
            System.out.print("Enter new code: ");
            String newCode = scanner.nextLine();
            System.out.println("Code changed: " + locker.changeCode(currentCode, newCode));
        }
    }
}
