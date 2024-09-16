package day076;

public class hw5 {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        int[] record = new int[n + 2];
        record[0] = 1;
        record[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            record[i] = nums[i - 1];
        }
        return f(record, 1, n, dp);
    }
    public int f(int[] record, int l, int r, int[][] dp) {
        if (dp[l][r] != -1) {
            return dp[l][r];
        }
        if (l == r) {
            dp[l][r] = record[l - 1] * record[l] * record[l + 1];
            return dp[l][r];
        }
        int ans = Math.max(record[l - 1] * record[l] * record[r + 1] + f(record, l + 1 , r, dp), record[l - 1] * record[r] * record[r + 1] + f(record, l, r - 1, dp));
        for (int i = l + 1; i < r; i++) {
            ans = Math.max(ans, record[l - 1] * record[i] * record[r+1] + f(record, l, i - 1,dp) + f(record, i + 1, r, dp));
        }
        dp[l][r] = ans;
        return ans;
    }
}
