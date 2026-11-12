package week11.practice_problems;

import java.util.Arrays;

public class RemoveDuplicatesSortedArray {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int uniqueIndex = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[uniqueIndex]) {
                uniqueIndex++;
                nums[uniqueIndex] = nums[i];
            }
        }
        return uniqueIndex + 1;
    }

    public static void main(String[] args) {
        int[] first = {1, 1, 2, 2, 2, 3, 4, 4, 5};
        int length1 = removeDuplicates(first);
        System.out.println("length = " + length1);
        System.out.println("nums[0.." + (length1 - 1) + "] = " +
                Arrays.toString(Arrays.copyOf(first, length1)));

        int[] custom = {-2, -2, 0, 0, 3, 3, 7};
        int length2 = removeDuplicates(custom);
        System.out.println("length = " + length2);
        System.out.println("nums[0.." + (length2 - 1) + "] = " +
                Arrays.toString(Arrays.copyOf(custom, length2)));
    }
}
