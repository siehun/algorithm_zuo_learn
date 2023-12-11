package day067;

public class hw4 {
    public int longestPalindromeSubseq(String s) {
        if (s == null) {
            return 0;
        }
        char[] chs = s.toCharArray();
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            if (i + 1 < n) {
                dp[i][i + 1] = chs[i] == chs[i + 1] ? 2 : 1;
            }
            for (int j = i + 2; j < n; j++) {
                if (chs[i] == chs[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else{
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }

            }
        }
        return dp[0][n - 1];
    }
    public int longestPalindromeSubseq1(String s) {
        if (s == null) {
            return 0;
        }
        char[] chs = s.toCharArray();
        int n = s.length();
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int leftbottom = 0, backup;
            dp[i] = 1;
            if (i + 1 < n) {
                leftbottom = dp[i + 1];
                dp[i + 1] = chs[i] == chs[i + 1] ? 2 : 1;
            }
            for (int j = i + 2; j < n; j++) {
                backup = dp[j];
                if (chs[i] == chs[j]) {
                    dp[j] = leftbottom + 2;
                } else{
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                leftbottom = backup;
            }
        }
        return dp[n - 1];
    }
    public int f1(char[] chr, int i, int j) {
        if (i == j) {
            return 1;
        }
        if (i + 1 == j) {
            return chr[i] == chr[j] ? 2 : 1;
        }
        if (chr[i] == chr[j]) {
            return f1(chr, i + 1, j - 1) + 2;
        } else {
            return Math.max(f1(chr, i + 1, j), f1(chr, i, j - 1));
        }
    }


    public static void main(String[] args) {
        String a = "abcdefg";
    }
}
