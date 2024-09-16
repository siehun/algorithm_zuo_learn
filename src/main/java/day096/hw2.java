package day096;

import java.util.Arrays;

public class hw2 {
    public static int[] randomArray(int n, int v) {
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = (int) (Math.random() * v + 1);
        }
        return ans;
    }
    public static void main(String[] args) {
        int N = 200;
        int V = 1000;
        int testTimes = 10000;
        System.out.println("start");
        for (int i = 0; i < testTimes; i++) {
            int n = (int) (Math.random() * N) + 1;
            int[] arr = randomArray(n, V);
            String ans1 = nim1(arr);
            String ans2 = nim2(arr);
            if (!ans1.equals(ans2)) {
                System.out.println("false");
            }
        }
        System.out.println("end");
    }
    public static String nim1(int[] arr) {
        int eor = 0;
        for (int num : arr) {
            eor ^= num;
        }
        return eor != 0 ? "先手" : "后手";
    }
    public static String nim2(int[] arr) {
        int len = arr.length;
        int max = 0;
        for (int i : arr) {
            max = Math.max(max, i);
        }
        int[] sg = new int[max + 1];
        boolean[] appear = new boolean[max + 1];
        for (int i = 1; i <= max; i++) {
            Arrays.fill(appear, false);
            for (int j = 0; j < i; j++) {
                // 下一个状态为0 - i个
                appear[sg[j]] = true;
            }
            for (int s = 0; s <= max; s++) {
                // 查一下哪个数没出现过
                if (!appear[s]) {
                    sg[i] = s;
                    break;
                }
            }
        }
        int eor = 0;
        for (int num : arr) {
            eor ^= sg[num];
        }
        return eor != 0 ? "先手" : "后手";
    }
}
