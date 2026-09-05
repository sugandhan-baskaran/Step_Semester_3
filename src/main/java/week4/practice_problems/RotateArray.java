package main.java.week4.practice_problems;

import java.util.Arrays;
import java.util.Scanner;

public class RotateArray {
    public static int[] rotateArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) return nums;
        
        k = k % nums.length;
        int[] newArray = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            newArray[(i + k) % nums.length] = nums[i];
        }
        
        System.arraycopy(newArray, 0, nums, 0, nums.length);
        
        return nums;
    }

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter size of playlist (array): ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        
        System.out.print("Enter playlist elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        
        System.out.print("Enter rotation steps (k): ");
        int k = sc.nextInt();
        
        int[] rotated = rotateArray(nums, k);
        System.out.println("Rotated Array: " + Arrays.toString(rotated));
    }
}
