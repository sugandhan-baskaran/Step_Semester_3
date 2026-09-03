package main.java.week3.assignment_problems;

import java.util.Scanner;

public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of days: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        
        System.out.print("Enter daily profit/loss figures: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        
        System.out.println("Maximum Contiguous Sum: " + maxSubArray(nums));
    }
}