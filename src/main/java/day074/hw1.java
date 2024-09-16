package day074;

import java.util.Arrays;
import java.util.Scanner;

public class hw1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 总重量
        int m = sc.nextInt();
        // 物品个数
        int n = sc.nextInt();
        int[][] item = new int[n+1][3];
        for (int i = 1; i <= n; i++) {
            // 重量
            item[i][0] = sc.nextInt();
            // 价值
            item[i][1] = sc.nextInt();
            // 组数
            item[i][2] = sc.nextInt();
        }
        Arrays.sort(item, (a, b) -> a[2] - b[2]);
        int teams = 1;
        for (int i = 2; i <= n; i++) {
            if (item[i-1][2] != item[i][2]) {
                teams++;
            }
        }
        int[][] dp = new int[teams+1][m+1];
        for (int start = 1, end = 2, i = 1; start <= n; i++) {
            // start -- end - 1同时保证不会越界
            while (end <= n && item[end][2] == item[start][2]) {
                end++;
            }
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                for (int k = start; k < end; k++) {
                    if (j - item[k][0] >= 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - item[k][0]] + item[k][1]);
                    }
                }
            }
            start = end++;
        }
        System.out.println(dp[teams][m]);
    }
}
