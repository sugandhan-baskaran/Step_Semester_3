package week10.assignment_problems;

public class ExamScoreBandCounter {
    public static int countInBand(int[] scores, int low, int high) {
        int firstAtLeastLow = lowerBound(scores, low);
        int firstGreaterThanHigh = upperBound(scores, high);
        return firstGreaterThanHigh - firstAtLeastLow;
    }

    private static int lowerBound(int[] scores, int target) {
        int left = 0;
        int right = scores.length;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (scores[middle] < target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return left;
    }

    private static int upperBound(int[] scores, int target) {
        int left = 0;
        int right = scores.length;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (scores[middle] <= target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return left;
    }
}