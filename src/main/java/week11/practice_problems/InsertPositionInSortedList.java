package week11.practice_problems;

public class InsertPositionInSortedList {
    public static int searchInsertPosition(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) return mid;
            if (nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }

    public static void main(String[] args) {
        System.out.println(searchInsertPosition(new int[]{1, 3, 5, 6}, 5));
        System.out.println(searchInsertPosition(new int[]{1, 3, 5, 6}, 2));
        System.out.println(searchInsertPosition(new int[]{1, 3, 5, 6}, 7));
    }
}
