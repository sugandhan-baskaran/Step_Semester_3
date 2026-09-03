package main.java.week3.practice_problems;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSortedArrays {
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }
        
        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }
        
        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }
        
        return result;
    }

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter size of first sorted array: ");
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        if (n1 > 0) {
            System.out.print("Enter elements for first array: ");
            for (int i = 0; i < n1; i++) arr1[i] = sc.nextInt();
        }
        
        System.out.print("Enter size of second sorted array: ");
        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        if (n2 > 0) {
            System.out.print("Enter elements for second array: ");
            for (int i = 0; i < n2; i++) arr2[i] = sc.nextInt();
        }
        
        int[] merged = mergeSortedArrays(arr1, arr2);
        System.out.println("Merged Array: " + Arrays.toString(merged));
    }
}
