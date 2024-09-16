package day074;
import java.util.*;

public class hw2 {
    // 转化为分组背包问题
    public int maxValueOfCoins(List<List<Integer>> piles, int m) {
        int n = piles.size();
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            // 对组数进行遍历，同时进行剪枝
            List<Integer> team = piles.get(i - 1);
            int t = Math.min(team.size(), m);
            //前缀和
            int[] pre = new int[t];
            pre[0] = team.get(0);
            for (int j = 1; j < t; j++) {
                pre[j] = team.get(j)+ pre[j - 1];
            }
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                for (int k = 0; k < t; k++) {
                    if (j - k - 1 >= 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - (k+1)] + pre[k]);
                    }
                }
            }
        }
        return dp[n][m];
    }
}
