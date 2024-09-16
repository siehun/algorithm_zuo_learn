package day076;

public class hw6 {
    public int countEval(String str, int result) {
        char[] s = str.toCharArray();
        int n = s.length;
        // dp表前二维要记录位置, 第三维要记录两种结果对于的个数
        int[][][] dp = new int[n][n][];
        int[] ft = f(s, 0, n - 1, dp);
        return ft[result];
    }
    public int[] f(char[] s, int l, int r, int[][][] dp) {
        if (dp[l][r] != null) {
            return dp[l][r];
        }
        if (l == r) {
            int f = s[l] =='0' ? 1 : 0;
            int t = s[l] =='1' ? 1 : 0;
            dp[l][r] = new int[]{f, t};
            return dp[l][r];
        }
        int[] tmp;
        int f = 0;
        int t = 0;
        for (int i = l + 1; i < r; i += 2) {
            tmp = f(s, l, i - 1, dp);
            int a = tmp[0];
            int b= tmp[1];
            tmp = f(s, i + 1, r, dp);
            int c = tmp[0];
            int d = tmp[1];
            if (s[i] == '&') {
                f += a * c + a * d + b* c;
                t += b * d;
            } else if (s[i] =='|') {
                f += a * c;
                t += a * d + b * c + b * d;
            } else {
                f += a * c + b * d;
                t += a * d + b * c;
            }
        }
        int[] ft = new int[] { f,t };
        dp[l][r] = ft;
        return ft;
    }
}
