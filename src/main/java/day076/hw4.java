package day076;

import java.util.Arrays;

public class hw4 {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int m = cuts.length;
        // 对cuts数组进行枚举 1 -- m
        int[][] dp = new int[m+1][m+1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = -1;
            }
        }
        // 进行简单的预处理，
        int[] arr = new int[m + 2];
        for (int i = 1; i < m + 1; i++) {
            arr[i] = cuts[i - 1];
        }
        arr[m + 1] = n;
        return f(arr, cuts, 1, m, dp);
    }
    public int f(int[] arr, int[] cuts, int l, int r, int[][] dp) {
        if (l > r) {
            return 0;
        }
        if (dp[l][r] != -1) {
            return dp[l][r];
        }
        if (l == r) {
            dp[l][r] = arr[r + 1] - arr[l - 1];
            return dp[l][r];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = l; i <= r; i++) {
            ans = Math.min(ans, f(arr, cuts, l , i - 1, dp) + f(arr, cuts, i + 1, r, dp));
        }
        dp[l][r] = ans + arr[r + 1] - arr[l - 1];
        return dp[l][r];
    }
}
