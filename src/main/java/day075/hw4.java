package day075;

import java.util.Scanner;

public class hw4 {
    public static int MAXN = 101;
    public static int MAXW = 40001;
    // 价值
    public static int[] v = new int[MAXN];
    // 重量
    public static int[] w = new int[MAXN];
    // 数量
    public static int[] c = new int[MAXN];
    //队列
    public static int[] queue = new int[MAXW];
    public static int[] dp = new int[MAXW];
    public static int l, r;
    public static int n, t;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
            c[i] = sc.nextInt();
        }
        System.out.println(compute2());
    }

    public static int compute() {
        int[][] dp = new int[n + 1][t + 1];
        for (int i = 1; i <= n; i++) {
            for (int mod = 0; mod <= Math.min(t, w[i] - 1); mod++) {
                l = r = 0;
                for (int j = mod; j <= t; j += w[i]) {
                    while (l < r && value1(dp, i, queue[r - 1]) <= value1(dp, i, j)) {
                        r--;
                    }
                    queue[r++] = j;
                    // 重量乘数量加一
                    if (queue[l] == j - w[i] * (c[i] + 1)) {
                        l++;
                    }
                    dp[i][j] = value1(dp, i, queue[l]) + j / w[i] * v[i];
                }
            }
        }
        return dp[n][t];
    }
    public static int value1(int[][] dp, int i, int j) {
        return dp[i - 1][j] - j / w[i] * v[i];
    }
    public static int value2( int i, int j) {
        return dp[j] - j / w[i] * v[i];
    }
    public static int compute2() {
        for (int i = 1; i <= n; i++) {
            for (int mod = 0; mod <= Math.min(t, w[i] - 1); mod++) {
                l = r = 0;
                // 用cnt控制元素个数，j进行边界
                for (int j = t - mod, cnt = 1; j >= 0 && cnt <= c[i]; j -= w[i], cnt++) {
                    while (l < r && value2(i, queue[r-1]) <= value2(i, j)) {
                        r--;
                    }
                    queue[r++] = j;
                }
                // j 当前所求
                // enter 要进入队列的元素
                for (int j = t - mod, enter = j - w[i] * c[i]; j >= 0; j-=w[i], enter-=w[i]) {
                    if (enter >= 0) {
                        while (l < r && value2(i, queue[r - 1]) <= value2(i, enter)) {
                            r--;
                        }
                        queue[r++] = enter;
                    }
                    dp[j] = value2(i,queue[l]) + j / w[i] * v[i];
                    if (queue[l] == j) {
                        l++;
                    }
                }
            }
        }
        return dp[t];
    }
}
