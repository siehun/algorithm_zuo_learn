package day096;

import java.util.Arrays;

public class hw4 {
    public static int MAXN = 201;
    public static int[] f = new int[26];
    public static String[][][] dp = new String[MAXN][MAXN][MAXN];
    static {
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i <= 25; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
    }
    public static int[] sg = new int[MAXN];
    public static boolean[] appear = new boolean[MAXN];
    public static void build() {
        for (int i = 1; i < MAXN; i++) {
            Arrays.fill(appear, false);
            for (int j = 0; j < f.length && i - f[j] >= 0; j++) {
                appear[sg[i - f[j]]] = true;
            }
            for (int s = 0; s < MAXN; s++) {
                if (!appear[s]) {
                    sg[i] = s;
                    break;
                }
            }
        }
    }
    public static String win1(int a, int b, int c) {
        // 假设当前的先手来行动
        // 注意不是全局的先手，是当前的先手来行动！
        // 当前！当前！当前！
        if (a + b + c == 0) {
            // 当前的先手，面对这个局面
            // 返回当前的后手赢
            return "后手";
        }
        if (dp[a][b][c] != null) {
            return dp[a][b][c];
        }
        String ans = "后手"; // ans : 赢的是当前的先手，还是当前的后手
        for (int i = 0; i < f.length; i++) {
            if (f[i] <= a) {
                if (win1(a - f[i], b, c).equals("后手")) {
                    // 后续过程的赢家是后续过程的后手
                    // 那就表示当前的先手，通过这个后续过程，能赢
                    ans = "先手";
                    break;
                }
            }
            if (f[i] <= b) {
                if (win1(a, b - f[i], c).equals("后手")) {
                    // 后续过程的赢家是后续过程的后手
                    // 那就表示当前的先手，通过这个后续过程，能赢
                    ans = "先手";
                    break;
                }
            }
            if (f[i] <= c) {
                if (win1(a, b, c - f[i]).equals("后手")) {
                    // 后续过程的赢家是后续过程的后手
                    // 那就表示当前的先手，通过这个后续过程，能赢
                    ans = "先手";
                    break;
                }
            }
        }
        dp[a][b][c] = ans;
        return ans;
    }
    public static String win2(int a, int b, int c) {
        return (sg[a] ^ sg[b] ^ sg[c]) != 0 ? "先手" : "后手";
    }
    public static void main(String[] args) {
        build();
        System.out.println("start");
        for (int a = 0; a < MAXN; a++) {
            for (int b = 0; b < MAXN; b++) {
                for (int c= 0; c < MAXN; c++) {
                    String ans1 = win1(a, b, c);
                    String ans2 = win2(a, b, c);
                    if (!ans1.equals(ans2)) {
                        System.out.println("出错了");
                    }
                }
            }
        }
        System.out.println("测试结束");
    }
}
