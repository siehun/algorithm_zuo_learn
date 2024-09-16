package day073;

import java.util.Scanner;

public class hw2 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] cost = new int[n + 1];
        int[] val = new int[n + 1];
        int ans = 0;
        int m = 1;

        for (int i = 1; i <= n; i++) {
            int pre = sc.nextInt();
            int cur = sc.nextInt();
            int happy = sc.nextInt();
            int well = pre - cur - cur;
            if (well >= 0) {
                x += well;
                ans += happy;
            } else {
                cost[m] = -well;
                val[m++] = happy;
            }
        }
        ans += compute(cost, val, m, x);
        System.out.println(ans);
    }
    public static int compute(int[] cost, int[] val, int m, int x) {
        int ans = 0;
        int[] dp = new int[x + 1];
        for (int i = 1; i < m; i++) {
            for (int j = x; j >= cost[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - cost[i]] + val[i]);
            }
        }
        return dp[x];
    }

}
