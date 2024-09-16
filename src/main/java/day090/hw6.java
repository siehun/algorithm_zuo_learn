package day090;

import java.util.HashMap;

public class hw6 {
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    public static int len2(int[] arr) {
        int max = 0;
        int gcd = 0;
        for (int num : arr) {
            max = Math.max(max, num);
            if (num != 0) {
                gcd = num;
            }
        }
        if (gcd == 0) {
            return arr.length;
        }
        HashMap<Integer, Integer> cnts = new HashMap<>();
        for (int num : arr) {
            if (num != 0) {
                gcd = gcd(gcd, num);
            }
            cnts.put(num, cnts.getOrDefault(num, 0) + 1);
        }
        int ans = max / gcd;
        int maxCnt = 0;
        for (int key : cnts.keySet()) {
            if (key != 0) {
                ans += cnts.get(key) - 1;
            }
            maxCnt = Math.max(maxCnt, cnts.get(key));
        }
        ans += cnts.getOrDefault(0, maxCnt > 1 ? 1 : 0);
        return ans;
    }
}
