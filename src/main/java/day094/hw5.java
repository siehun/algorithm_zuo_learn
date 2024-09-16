package day094;

import java.util.Arrays;
import java.util.Scanner;

public class hw5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int trees = sc.nextInt();
            int days = sc.nextInt();
            int[][] tre = new int[trees][2];
            for (int j = 0; j < trees; j++) {
                tre[j][0] = sc.nextInt();
            }
            for (int j = 0; j < trees; j++) {
                tre[j][1] = sc.nextInt();
            }
            Arrays.sort(tre, (a, b) -> a[1] - b[1]);
            int ans = compute(tre, days);
            System.out.println(ans);
        }
    }
    public static int compute(int[][] tre, int days) {
        int n = tre.length;
        int[][] dp = new int[n + 1][days + 1];
        for (int j = 1; j <= days; j++) {
            for (int i = 1; i <= n; i++) {
                dp[i][j] = Math.max(dp[i- 1][j], dp[i - 1][j - 1] + tre[i-1][0] +tre[i - 1][1] * (j - 1));
            }
        }
        return dp[n][days];


    }
}
