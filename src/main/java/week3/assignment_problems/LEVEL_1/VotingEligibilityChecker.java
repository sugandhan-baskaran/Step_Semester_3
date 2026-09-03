package LEVEL_1;

import java.util.Scanner;

public class VotingEligibilityChecker {
    public void checkVotingEligibility(int age) {
        boolean isEligible = age >= 18;
        if (isEligible) {
            System.out.println("Eligible to vote");
        } else {
            System.out.println("Not eligible to vote");
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter your age: ");
            int age = sc.nextInt();
            VotingEligibilityChecker checker = new VotingEligibilityChecker();
            checker.checkVotingEligibility(age);
        }
    }
}