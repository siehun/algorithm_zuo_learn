package day068;

public class hw2 {
    public int minDistance(String word1, String word2) {
        char[] chs1 = word1.toCharArray();
        char[] chs2 = word2.toCharArray();
        int ans = f1(chs1, chs2, 1, 1, 1);
        return ans;
    }
    public int f1(char[] chs1, char[] chs2, int a, int b, int c) {
        int n = chs1.length;
        int m = chs2.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int j = 1; j <= m; j++) {
            dp[0][j] = a * j;
        }
        for (int i = 1; i <= n; i++) {
            dp[i][0] = b * i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=m ;j++) {
                int p1 = Integer.MAX_VALUE;
                int p2 = Integer.MAX_VALUE;
                if (chs1[i - 1] == chs2[j - 1]) {
                    p1 = dp[i - 1][j - 1];
                }
                if (chs1[i - 1] != chs2[j - 1]) {
                    p2 = dp[i - 1][j - 1] + c;
                }
                int p3 = dp[i][j - 1] + a;
                int p4 = dp[i - 1][j] + b;
                dp[i][j] = Math.min(Math.min(p1, p2), Math.min(p3, p4));
            }
        }
        return dp[n][m];
    }
}
