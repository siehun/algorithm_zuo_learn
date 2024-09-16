package day076;

public class hw3 {
    public int minScoreTriangulation(int[] values) {
        int len = values.length;
        int[][] dp = new int[len][len];
        return f(values, 0, len - 1, dp);
    }
    public int f(int[] values, int l, int r, int[][] dp) {
        if (l == r || l + 1 == r) {
            return 0;
        }
        if (dp[l][r] != 0) {
            return dp[l][r];
        }
        int ans = Integer.MAX_VALUE;
        int left = values[l];
        int right = values[r];
        for (int i = l + 1; i < r; i++) {
            ans = Math.min(ans, left * right * values[i] + f(values, l, i, dp) + f(values, i, r, dp));
        }
        dp[l][r] = ans;
        return ans;
    }
    // 分析格子依赖，以来l i, 以及 i r 的格子，其中i位于l,r之间, 简单分析为以来左边和下边的格子
    public int minScoreTriangulation1(int[] values) {
        int len = values.length;
        int[][] dp = new int[len][len];
        for (int l = len - 3; l >= 0; l--) {
            for (int r = l + 2; r < len; r++) {
                dp[l][r] = Integer.MAX_VALUE;
                for (int i = l +1; i < r; i++) {
                    dp[l][r] = Math.min(dp[l][r], values[l] * values[r] * values[i] + dp[l][i] + dp[i][r]);
                }
            }
        }
        return dp[0][len - 1];
    }
}
