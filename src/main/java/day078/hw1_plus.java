package day078;

import java.util.Scanner;

public class hw1_plus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] s = str.toCharArray();
        int n = s.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i <n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(f(s, 0, n - 1, dp));
    }
    // dp[l][r]从左边到右边能完整配对需要的个数
    public static int f(char[] s, int l, int r, int[][] dp) {
        if (l == r) {
            return 1;
        }
        if (l == r - 1) {
            if ((s[l] == '(' && s[r] == ')') || (s[l] == '[' && s[r] == ']')) {
                return 0;
            }
            return 2;
        }
        if (dp[l][r] != -1) {
            return dp[l][r];
        }
        int p1 = Integer.MAX_VALUE;
        if ((s[l] == '(' && s[r] == ')') || (s[l] == '[' && s[r] == ']')) {
            p1 = f(s, l + 1, r - 1, dp);
        }
        int p2 = Integer.MAX_VALUE;
        for(int m = l; m < r; m++) {
            p2 = Math.min(p2, f(s,l,m,dp) + f(s, m + 1, r, dp));

        }
        int ans = Math.min(p1, p2);
        dp[l][r] = ans;
        return ans;
    }
}
