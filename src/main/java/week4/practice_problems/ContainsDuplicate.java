package main.java.week4.practice_problems;

import java.util.Scanner;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of students (array size): ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        
        System.out.print("Enter roll numbers: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        
        System.out.println("Contains Duplicate: " + containsDuplicate(nums));
    }
}