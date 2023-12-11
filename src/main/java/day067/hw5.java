package day067;

import java.util.Scanner;

public class hw5 {
    public static int mod = 1000000007;

    public static int f1(int nodes, int height) {
        if (nodes == 0) {
            return 1;
        }
        if (height == 0) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < nodes; i++) {
            ans += f1(i, height - 1) * f1(nodes - 1 - i, height - 1);
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nodes = sc.nextInt();
        int height = sc.nextInt();
        int[][] record = new int[nodes + 1][height + 1];
        for (int i = 0; i <= height; i++) {
            record[0][i] = 1;
        }
        for (int i = 1; i <= nodes; i++) {
            record[i][0] = 0;
        }
        for (int j = 1; j <= height; j++) {
            for (int i = 1; i <= nodes; i++) {
                long ans = 0;
                for (int k = 0; k < i; k++) {
                    ans = (ans + ((long)record[k][j - 1] * record[i - 1 - k][j - 1])% mod) % mod;
                }
                record[i][j] = (int)ans;
            }
        }
        System.out.println(record[nodes][height]);

    }
}
