package main.java.week3.practice_problems;

import java.util.Arrays;
import java.util.Scanner;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        
        System.out.print("Enter prices: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        
        System.out.print("Enter target budget: ");
        int target = sc.nextInt();
        
        int[] result = twoSum(nums, target);
        System.out.println("Result: " + Arrays.toString(result));
    }
}
