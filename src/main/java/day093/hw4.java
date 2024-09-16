package day093;

import java.util.*;
public class hw4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] peo = new int[num];
        for(int i = 0; i < num; i++) {
            peo[i] = sc.nextInt();
        }
        Arrays.sort(peo);
        int[] dp = new int[num];
        int ans = f( peo, dp);
        System.out.println(ans);
    }
    public static int f1(int i, int[] peo) {
        if (i == 1) {
            return peo[0];
        }
        if (i == 2) {
            return peo[1];
        }
        if (i == 3) {
            return peo[0] + peo[1] + peo[2];
        }
        int ans1 = f1(i - 1, peo) + peo[0] + peo[i - 1];
        int ans2 = f1(i - 2, peo) + peo[i - 1] + 2 * peo[1] + peo[0];
        return Math.min(ans1, ans2);
    }
    public static int f( int[] peo, int[] dp) {
        int n = dp.length;
        if (n >= 1) {
            dp[0] = peo[0];
        }
        if (n >= 2) {
            dp[1] = peo[1];
        }
        if (n >= 3) {
            dp[2] = peo[0] + peo[1] + peo[2];
        }
        for (int j = 3; j < n; j++) {
            int ans1 = dp[j - 1] + peo[j] + peo[0];
            int ans2 = dp[j - 2] + 2 * peo[1] + peo[0] + peo[j];
            dp[j] = Math.min(ans1, ans2);
        }
        return dp[n - 1];

    }
}
