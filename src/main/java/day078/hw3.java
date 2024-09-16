package day078;

import java.util.Scanner;

public class hw3 {
    public static void main(String[] args) {
        int MOD = 19650827;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // 0 l r n - 1
        int[][][] dp = new int[n][n][2];
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] < arr[i + 1]){
                dp[i][i + 1][0] = 1;
                dp[i][i + 1][1] = 1;
            }
        }
        for (int l = n - 3; l >= 0; l--) {
            for (int r = l + 2; r < n; r++) {
                if (arr[l] < arr[l + 1]) {
                    dp[l][r][0] = (dp[l][r][0] + dp[l + 1][r][0]) % MOD;
                }
                if (arr[l] < arr[r]) {
                    dp[l][r][0] = (dp[l][r][0] + dp[l + 1][r][1]) % MOD;
                }
                if (arr[r] > arr[l]) {
                    dp[l][r][1] = (dp[l][r][1] + dp[l][r - 1][0]) % MOD;
                }
                if (arr[r] > arr[r - 1]) {
                    dp[l][r][1] = (dp[l][r][1] + dp[l][r - 1][1]) % MOD;
                }
            }
        }
        int ans = dp[0][n-1][0] + dp[0][n-1][1];
        System.out.println(ans % MOD);

    }
}
