package main.java.week4.assignment_problems;

import java.util.HashMap;
import java.util.Scanner;

public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSumCounts = new HashMap<>();
        prefixSumCounts.put(0, 1);
        
        int currentSum = 0;
        int count = 0;
        
        for (int num : nums) {
            currentSum += num;
            
            if (prefixSumCounts.containsKey(currentSum - k)) {
                count += prefixSumCounts.get(currentSum - k);
            }
            
            prefixSumCounts.put(currentSum, prefixSumCounts.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of days logged: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        
        System.out.print("Enter daily attendance changes: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        
        System.out.print("Enter target sum (k): ");
        int k = sc.nextInt();
        
        System.out.println("Total Subarrays Found: " + subarraySum(nums, k));
    }
}
