package day074;

import java.util.Scanner;

public class hw3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int m = sc.nextInt();
        int[][] medic = new int[m + 1][2];
        for (int i = 1; i <= m; i++) {
            medic[i][0] = sc.nextInt();
            medic[i][1] = sc.nextInt();
        }
//        int[][] dp = new int[m + 1][t + 1];
//        for (int i = 1; i <= m; i++) {
//            for (int j = 0; j <= t; j++) {
//                dp[i][j] = dp[i - 1][j];
//                if (j - medic[i][0] >= 0) {
//                    dp[i][j] = Math.max(dp[i][j], dp[i][j - medic[i][0]] + medic[i][1]);
//                }
//            }
//        }
//        System.out.println(dp[m][t]);
        long[] dp = new long[t + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = medic[i][0]; j <= t; j++) {
                dp[j] = Math.max(dp[j], dp[j - medic[i][0]] + medic[i][1]);
            }
        }
        System.out.println(dp[t]);
    }
}
