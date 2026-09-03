package main.java.week3.assignment_problems;

import java.util.Arrays;
import java.util.Scanner;

public class ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * suffix;
            suffix = suffix * nums[i];
        }
        
        return answer;
    }

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        
        System.out.print("Enter prices: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        
        int[] result = productExceptSelf(nums);
        System.out.println("Result: " + Arrays.toString(result));
    }
}