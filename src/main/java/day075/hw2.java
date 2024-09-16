package day075;

import java.util.Scanner;

public class hw2 {
    public static int MAXN = 101;
    public static int[] value = new int[10 * MAXN];
    public static int[] weight = new int[10 * MAXN];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int W = sc.nextInt();
        int index = 1;
        for (int i = 1; i <= n; i++) {
            int v= sc.nextInt();
            int w = sc.nextInt();
            int c = sc.nextInt();
            for (int cnt = 1; cnt <= c; cnt *= 2) {
                value[index] = v * cnt;
                weight[index++] = w * cnt;
                c -= cnt;
            }
            if (c > 0) {
                value[index] = c * v;
                weight[index++] = c * w;
            }
        }
        int ans = f3(  W, index);
        System.out.println(ans);
    }
    public static int f2(  int W, int n) {
        int[][] dp = new int[n][W+1];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= W; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - weight[i] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        return dp[n - 1][W];
    }
    public static int f3(int W, int n) {
        int[] dp = new int[W + 1];
        for (int i = 1; i < n; i++) {
            for (int j = W; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        return dp[W];
    }
}
