package day074;

import java.util.Arrays;
import java.util.Scanner;

public class hw6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int H = sc.nextInt();
        int[][] record = new int[N+1][2];
        int max = -1;
        for (int i = 1; i <= N; i++) {
            record[i][0] = sc.nextInt();
            record[i][1] = sc.nextInt();
            max = Math.max(record[i][0], max);
        }
        // 重量 / 开销
        int[][] dp = new int[N+1][max+H + 1];
        Arrays.fill(dp[0], 1, max+H+1, Integer.MAX_VALUE);
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= max+H; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - record[i][0] >= 0 && dp[i][j - record[i][0]]!= Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j - record[i][0]] + record[i][1]);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int j = H; j<= max+H; j++) {
            ans = Math.min(ans, dp[N][j]);
        }
        System.out.println(ans);
    }
}
