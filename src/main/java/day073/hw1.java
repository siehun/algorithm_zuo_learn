package day073;

import java.util.Scanner;

public class hw1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int m = sc.nextInt();
        int[][] medic = new int[m + 1][2];
        for (int i = 1; i <= m; i++) {
            medic[i][0] = sc.nextInt();
            medic[i][1] = sc.nextInt();
        }
        int[][] dp = new int[m+1][t+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= t; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - medic[i][0] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-medic[i][0]] + medic[i][1]);
                }
            }
        }
        solu(t, m ,medic);
     //   System.out.println(dp[m][t]);
    }
    public static void solu(int t, int m, int[][] medic) {
        int[] dp = new int[t + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = t; j >= medic[i][0]; j--) {
                dp[j] = Math.max(dp[j], dp[j - medic[i][0]] + medic[i][1]);
            }
        }
        System.out.println(dp[t]);
    }
}
