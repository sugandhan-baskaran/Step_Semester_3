package week11.practice_problems;

public class WarehouseBinGridScan {
    public static void warehouseSummary(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            System.out.println("total = 0, maxCoordinate = Not Found");
            return;
        }

        int total = 0;
        int max = grid[0][0];
        int maxRow = 0, maxCol = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                total += grid[i][j];
                if (grid[i][j] > max) {
                    max = grid[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        System.out.println("total = " + total +
                ", maxCoordinate = (" + maxRow + ", " + maxCol + ")");
    }

    public static void main(String[] args) {
        warehouseSummary(new int[][]{
            {4, 9, 2},
            {7, 1, 6},
            {3, 12, 5}
        });

        warehouseSummary(new int[][]{
            {5, 5},
            {2, 1}
        });
    }
}
