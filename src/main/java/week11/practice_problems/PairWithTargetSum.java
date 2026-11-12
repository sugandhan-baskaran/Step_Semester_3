package week11.practice_problems;

import java.util.HashSet;
import java.util.Set;

public class PairWithTargetSum {
    public static boolean hasPairWithSum(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();

        for (int value : nums) {
            int needed = target - value;
            if (seen.contains(needed)) return true;
            seen.add(value);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasPairWithSum(new int[]{2, 7, 11, 15}, 9));
        System.out.println(hasPairWithSum(new int[]{3, 4, 6}, 20));
        System.out.println(hasPairWithSum(new int[]{-3, 8, 1, 5}, 2));
    }
}
