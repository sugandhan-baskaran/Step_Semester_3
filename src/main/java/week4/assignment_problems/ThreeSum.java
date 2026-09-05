package main.java.week4.assignment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ThreeSum {
    public static int[][] threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    triplets.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        int[][] result = new int[triplets.size()][3];
        for (int i = 0; i < triplets.size(); i++) {
            result[i][0] = triplets.get(i).get(0);
            result[i][1] = triplets.get(i).get(1);
            result[i][2] = triplets.get(i).get(2);
        }
        
        return result;
    }

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of transactions: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        
        System.out.print("Enter transactions: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        
        int[][] result = threeSum(nums);
        System.out.print("Zero-Sum Triplets: [");
        for (int i = 0; i < result.length; i++) {
            System.out.print(Arrays.toString(result[i]));
            if (i < result.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
