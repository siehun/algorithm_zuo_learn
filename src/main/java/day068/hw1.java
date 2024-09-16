package day068;

public class hw1 {
    public int numDistinct2(String s, String t) {
        char[] chr1 = s.toCharArray();
        char[] chr2 = t.toCharArray();
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[m + 1][n + 1];
        // i t
        // j s
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1];
                if (chr1[j - 1] == chr2[i - 1]) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
    public static int numDistinct(String s, String t) {
        char[] chr1 = s.toCharArray();
        char[] chr2 = t.toCharArray();
        int n = s.length();
        int m = t.length();
        int[] dp = new int[n + 1];
        // i t
        // j s
        for (int j = 0; j <= n; j++) {
            dp[j] = 1;
        }
        for (int i = 1; i <= m; i++) {
            int bottom = 0;
            int leftup = dp[0];
            dp[0]  = 0;
            for (int j = 1; j <= n; j++) {
                bottom = dp[j];
                dp[j] = dp[j - 1];
                if (chr1[j - 1] == chr2[i - 1]) {
                    dp[j] += leftup;
                }
                leftup = bottom;
            }
            for (int col = 0; col <= n; col++) {
                System.out.print(dp[col] + " ");
            }
            System.out.println();
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String s = "rabbbit", t = "rabbit";
        numDistinct(s, t);
    }
}
