package day096;

import java.util.Arrays;

public class hw3 {
    public static int MAXN = 101;
    public static String[][][] dp = new String[MAXN][MAXN][MAXN];
    public static String win3(int a, int b, int m) {
        return  a % (m + 1) != b % (m + 1) ? "先手" : "后手";
    }
    public static String win1(int a, int b, int m) {
        return  a % (m + 1) != b % (m + 1) ? "先手" : "后手";
    }
    public static String win2(int a, int b, int m) {
        int max = Math.max(a, b);
        boolean[] appear = new boolean[m + 1];
        int[] sg = new int[max + 1];
        for (int i = 1; i <= max; i++) {
            Arrays.fill(appear, false);
            for (int j = 1; j <= m && i - j >= 0; j++) {
                appear[sg[i - j]] = true;
            }
            for (int s = 0; s <= m; s++) {
                if (!appear[s]) {
                    sg[i] = s;
                    break;
                }
            }
        }
        return (sg[a] ^ sg[b]) != 0 ? "先手" : "后手";
    }
    public static void main(String[] args) {
        System.out.println("start");
        for (int a = 0; a < MAXN; a++) {
            for (int b = 0; b < MAXN; b++) {
                for (int m = 1; m < MAXN; m++) {
                    String ans1 = win1(a, b, m);
                    String ans2 = win2(a, b, m);
                    String ans3 = win3(a, b, m);
                    if (!ans1.equals(ans2) || !ans1.equals(ans3)) {
                        System.out.println("falut");
                    }
                }

            }
        }
        System.out.println("end");
    }
}
