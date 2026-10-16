package week10.practice_problems;

import java.util.Arrays;
import java.util.Scanner;

public class InPlaceArrayReversal {
    public static void reverse(int[] values) {
        for (int left = 0, right = values.length - 1; left < right; left++, right--) {
            int temporary = values[left];
            values[left] = values[right];
            values[right] = temporary;
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int[] values = new int[scanner.nextInt()];
            for (int index = 0; index < values.length; index++) {
                values[index] = scanner.nextInt();
            }
            reverse(values);
            System.out.println(Arrays.toString(values));
        }
    }
}