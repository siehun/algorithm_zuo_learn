package day075;

import java.util.Scanner;

public class hw3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String start = sc.next();
        String end = sc.next();
        int si = start.indexOf(":");
        int ei = end.indexOf(":");
        int sh = Integer.valueOf(start.substring(0,start.indexOf(":")));
        int eh = Integer.valueOf(end.substring(0,end.indexOf(":")));
        int sm = Integer.valueOf(start.substring(start.indexOf(":") + 1));
        int em = Integer.valueOf(end.substring(end.indexOf(":")+1));
        if (em < sm) {
            eh--;
            em += 60;
        }
        int ans = 0;
        // 我们把背包容量求出来
        int W = em - sm + 60 * (eh - sh);
        int n = sc.nextInt();
        // 花费
        int[] cost = new int[10 * n +1];
        // 收益
        int[] beautify = new int[10 * n + 1];
        int index = 1;
        for (int i = 1; i <= n; i++) {
            int t = sc.nextInt();
            int c = sc.nextInt();
            int p = sc.nextInt();
            if (t == 0) {
                ans += p * c;
                continue;
            }
            if (p == 0) {
                p = 1001;
            }
            for (int cnt = 1; cnt <= p; cnt*=2) {
                cost[index] = cnt * t;
                beautify[index++] = cnt * c;
                p -= cnt;
            }
            if (p > 0) {
                cost[index] = p * t;
                beautify[index++] = p * c;
            }
        }
//        int[][] dp = new int[index][W + 1];
//        for (int i = 1; i < index; i++) {
//            for (int j = 1; j <= W; j++) {
//                dp[i][j] = dp[i - 1][j];
//                if (j - cost[i] >= 0) {
//                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j- cost[i]] + beautify[i]);
//                }
//            }
//        }
//        System.out.println(ans + dp[index - 1][W]);
        int[] dp = new int[W+1];
        for (int i = 1; i < index; i++) {
            for (int j = W; j >= cost[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - cost[i]]+beautify[i]);
            }
        }
        System.out.println(dp[W]);
    }
}
