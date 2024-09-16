package day074;

public class hw5 {
    public boolean isMatch(String str, String pat) {
        char[] s = str.toCharArray();
        char[] p = pat.toCharArray();
        boolean ans = f1(s, p, 0, 0);
        return ans;
    }
    public boolean isMatch1(String str, String pat) {
        int m = str.length();
        int n = pat.length();
        char[] s = str.toCharArray();
        char[] p = pat.toCharArray();
        boolean[][] dp = new boolean[m+1][n + 1];
        dp[m][n] = true;
        for (int j = n - 1; j >= 0; j--) {
            dp[m][j] = p[j] == '*' && dp[m][j + 1];
        }
        for (int i = 0; i <= m - 1; i++) {
            dp[i][n] = false;
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (p[j] != '*') {
                    dp[i][j] = (s[i]==p[j] ||p[j]=='?') && dp[i+1][j+1];
                } else {
                    dp[i][j] = dp[i][j + 1] || dp[i+1][j];
                }
            }
        }
        return dp[0][0];

    }
    public boolean f1(char[] s, char[] p, int i, int j) {
        if (i == s.length) {
            if (j == p.length) {
                return true;
            } else {
                return p[j] == '*' && f1(s, p, i, j + 1);
            }
        } else if (j == p.length) {
            return false;
        } else {
            if (p[j] != '*') {
                return (s[i]==p[j] || p[j]=='?') &&f1(s, p, i + 1, j + 1);
            } else {
                boolean p1 = f1(s, p, i, j + 1);
                boolean p2 = f1(s, p, i + 1, j);
                return p1 || p2;
            }
        }

    }

    public static void main(String[] args) {
        hw5 hw = new hw5();
        boolean ans = hw.isMatch("aa","a");
        System.out.println(ans);
    }
}
