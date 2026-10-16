package week10.assignment_problems;

public class BusiestBusRow {
    public record Result(int rowIndex, int total) {}

    public static Result busiestRow(int[][] grid) {
        int bestRow = 0;
        int bestTotal = -1;

        for (int row = 0; row < grid.length; row++) {
            int total = 0;
            for (int students : grid[row]) {
                total += students;
            }
            if (total > bestTotal) {
                bestTotal = total;
                bestRow = row;
            }
        }
        return new Result(bestRow, bestTotal);
    }
}