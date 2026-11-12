package week11.assignment_problems;

import java.util.Arrays;

public class HeightLineUp {
    public static void lineUp(int[] heights) {
        for (int pass = 1; pass < heights.length; pass++) {
            boolean swapped = false;

            for (int j = 0; j < heights.length - pass; j++) {
                if (heights[j] > heights[j + 1]) {
                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;
                    swapped = true;
                }
            }

            System.out.println("Pass " + pass + ": " + Arrays.toString(heights));
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        lineUp(new int[]{4, 2, 5, 1});
        System.out.println();
        lineUp(new int[]{1, 3, 2, 4});
        System.out.println();
        lineUp(new int[]{9, 4, 7, 2, 5});
    }
}
