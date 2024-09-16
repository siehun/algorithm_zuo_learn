package day076;

import java.util.Arrays;

public class hw1 {
    public int minInsertions(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(0, n - 1, str, dp);
    }
    public int minInsertions1(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        int[][] dp = new int[n][n];
        for (int l = 0; l < n - 1; l++) {
            dp[l][l + 1] = str[l] == str[l + 1] ? 0 : 1;
        }
        for (int l = n - 3; l >= 0; l--) {
            for (int r = l + 2; r < n; r++) {
                if (str[l] == str[r]) {
                    dp[l][r] = dp[l + 1][r - 1];
                } else {
                    dp[l][r] = Math.min(dp[l][r - 1], dp[l + 1][r]) + 1;
                }
            }
        }
        return dp[0][n - 1];
    }
    public int f(int l, int r, char[] str, int[][] dp) {
        if (dp[l][r] != -1) {
            return dp[l][r];
        }
        if (l == r) {
            dp[l][r] = 0;
            return 0;
        }
        if (l == r - 1) {
            dp[l][r] = str[l] == str[r] ? 0 : 1;
            return dp[l][r];
        }
        if (str[l] == str[r]) {
            dp[l][r] = f(l + 1, r - 1, str, dp);
            return dp[l][r];
        } else {
            dp[l][r] =  Math.min(f(l + 1, r, str,dp), f(l, r- 1, str,dp)) + 1;
            return dp[l][r];
        }

    }
}
