package day067;

public class hw1 {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] record = new int[m];
        record[0] = grid[0][0];
        for (int j = 1; j < m; j++) {
            record[j] = grid[0][j] + record[j - 1];
        }
        for (int i = 1; i < n; i++) {
            record[0] = record[0] + grid[i][0];
            for (int j = 1; j < m; j++) {
                record[j] = Math.min(record[j - 1], record[j]) + grid[i][j];
            }
        }
        return record[m - 1];
    }
}
