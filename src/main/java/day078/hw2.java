package day078;

public class hw2 {
    public int strangePrinter(String str) {
        char[] s = str.toCharArray();
        int n = s.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return f(s, 0, n - 1, dp);
    }
    public int f(char[] s, int l, int r, int[][] dp) {
        if (l == r) {
            return 1;
        }
        if (l + 1 == r) {
            if (s[l] == s[r]) {
                return 1;
            }
            return 2;
        }
        if (dp[l][r] != -1) {
            return dp[l][r];
        }
        if (s[l] == s[r]) {
            dp[l][r] = f(s, l , r - 1, dp);
            return dp[l][r];
        }
        // 分析格子依赖 l m r, dp[l][r]依赖左边和下方的格子
        // dp[l][m] dp[m+1][r]
        int ans = Integer.MAX_VALUE;
        for (int m = l; m < r; m++) {
            ans = Math.min(ans, f(s, l, m, dp) + f(s, m + 1, r, dp));
        }
        dp[l][r] = ans;
        return ans;
    }
}
