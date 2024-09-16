package day075;

import java.util.Scanner;

public class hw1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int W = sc.nextInt();
        int[] value = new int[n+1];
        int[] weight = new int[n+1];
        int[] count = new int[n+1];
        for (int i = 1; i <= n; i++) {
            value[i] = sc.nextInt();
            weight[i] = sc.nextInt();
            count[i] = sc.nextInt();
        }
        int ans = f1(value, weight, count, W, n);
        System.out.println(ans);
    }
    // 最基本的分组背包解决问题，一个商品就是一个组，针对数量进行选择
    public static int f1(int[] val, int[] wei, int[] cou, int W, int n) {
        int[][] dp = new int[n+1][W+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                dp[i][j] = dp[i - 1][j];
                for (int cnt = 1; cnt <= cou[i] && j - cnt * wei[i] >= 0; cnt++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - cnt * wei[i]] + cnt * val[i]);
                }
            }
        }
        return dp[n][W];
    }
}
