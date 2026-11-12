package week11.assignment_problems;

import java.util.Arrays;

public class DiceThrowTally {
    public static int[] diceSort(int[] rolls) {
        int[] count = new int[7];

        for (int value : rolls) {
            if (value < 1 || value > 6) {
                throw new IllegalArgumentException("Dice values must be from 1 to 6");
            }
            count[value]++;
        }

        System.out.print("Counts: ");
        for (int value = 1; value <= 6; value++) {
            System.out.print(value + ":" + count[value]);
            if (value < 6) System.out.print(" ");
        }
        System.out.println();

        int[] sorted = new int[rolls.length];
        int index = 0;

        for (int value = 1; value <= 6; value++) {
            for (int occurrence = 0; occurrence < count[value]; occurrence++) {
                sorted[index++] = value;
            }
        }
        return sorted;
    }

    public static void main(String[] args) {
        System.out.println("Sorted: " + Arrays.toString(
                diceSort(new int[]{4, 1, 6, 4, 2, 1, 4})));
        System.out.println("Sorted: " + Arrays.toString(
                diceSort(new int[]{6, 3, 3, 1, 5, 2, 6, 1})));
    }
}
