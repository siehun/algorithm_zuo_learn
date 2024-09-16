package day073;

import java.util.Scanner;
import java.util.*;

public class hw5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 读数据
        int N = sc.nextInt();
        int m = sc.nextInt();
        // 记录价格
        int[] price = new int[m + 1];
        // 记录价值
        int[] val = new int[m + 1];
        // 记录归属
        int[][] follows = new int[m+1][2];
        // 记录数量
        int[] fans = new int[m+1];
        // 标记主商品
        boolean[] king = new boolean[m+1];
        for (int i = 1; i <= m; i++) {
            int v = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            price[i] = v;
            val[i] = v * p;
            king[i] = q == 0;
            if (q != 0) {
                // 记录附属关系
                follows[q][fans[q]++] = i;
            }
        }
        int ans = f(N, m, price, val, king,fans, follows);
        System.out.println(ans);
    }
    public static int f(int n, int m,int[] price, int[] val,boolean[]king, int[] fans,int[][] follow) {
        int[][] dp = new int[m+1][n+1];
        // 上次展开的主商品
        int p = 0;
        for (int i = 1; i <= m; i++) {
            // 只有主商品才展开
            if (king[i]) {
                for (int j = 0; j <=n; j++) {
                    dp[i][j] = dp[p][j];
                    if (j - price[i] >= 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[p][j-price[i]] + val[i]);
                    }
                    int fan1 = fans[i] >= 1 ? follow[i][0] : -1;
                    int fan2 = fans[i] >= 2 ? follow[i][1] : -1;
                    if (fan1 != -1 && j- price[i] - price[fan1] >= 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[p][j - price[i] - price[fan1]] + val[i] + val[fan1]);
                    }
                    if (fan2 != -1 && j- price[i] - price[fan2] >= 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[p][j - price[i] - price[fan2]] + val[i] + val[fan2]);
                    }
                    if (fan1 != -1 && fan2!=-1&&j- price[i] - price[fan1]-price[fan2] >= 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[p][j - price[i] - price[fan1] - price[fan2]] + val[i] + val[fan1] + val[fan2]);
                    }
                }
                p = i;
            }
        }
        return dp[p][n];
    }
}
