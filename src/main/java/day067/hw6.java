package day067;

import java.util.Arrays;

public class hw6 {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans = 0;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, f2(matrix, i, j, dp));
            }
        }
        return ans;
    }
    public int f2(int[][] matrix, int i, int j, int[][] dp) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return 0;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int cur = matrix[i][j];
        int max = 0;
        if (i - 1 >= 0 && matrix[i - 1][j] > cur) {
            max = Math.max(max, f2(matrix, i - 1, j, dp));
        }
        if (i + 1 < matrix.length && matrix[i + 1][j] > cur) {
            max = Math.max(max, f2(matrix, i + 1, j, dp));
        }
        if (j - 1 >= 0 && matrix[i][j - 1] > cur) {
            max = Math.max(max, f2(matrix, i, j - 1, dp));
        }
        if (j + 1 < matrix[0].length && matrix[i][j + 1] > cur) {
            max = Math.max(max, f2(matrix, i, j + 1, dp));
        }
        dp[i][j] = max + 1;
        return max + 1;
    }

    public int f1(int[][] matrix, int i, int j) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return 0;
        }
        int cur = matrix[i][j];
        int max = 0;
        if (i - 1 >= 0 && matrix[i - 1][j] > cur) {
            max = Math.max(max, f1(matrix, i - 1, j));
        }
        if (i + 1 < matrix.length && matrix[i + 1][j] > cur) {
            max = Math.max(max, f1(matrix, i + 1, j)) ;
        }
        if (j - 1 >= 0 && matrix[i][j - 1] > cur) {
            max = Math.max(max, f1(matrix, i, j - 1)) ;
        }
        if (j + 1 < matrix[0].length && matrix[i][j + 1] > cur) {
            max = Math.max(max, f1(matrix, i , j + 1));
        }
        return max + 1;
    }
}
