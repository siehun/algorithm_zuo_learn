package day096;

import java.util.Arrays;

public class hw1 {
    public static void main(String[] args) {
        int V = 1000;
        int testTimes = 10000;
        System.out.println("start");
        for (int i = 0; i < testTimes; i++) {
            int n = (int) (Math.random() * V);
            int m = (int) (Math.random() * V);
            String ans1 = bash1(n, m);
            String ans2 = bash2(n, m);
            if (!ans1.equals(ans2)) {
                System.out.println("faults curr");
            }
        }
        System.out.println("end");
    }
    public static String bash1(int n, int m) {
        return n % (m + 1) == 0 ? "后手" : "先手";
    }
    public static String bash2(int n, int m) {
        int[] sg = new int[n + 1];
        boolean[] appear = new boolean[m + 1];
        for (int i = 1; i <= n; i++) {
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
        return sg[n] != 0 ? "先手" : "后手";
    }
}
