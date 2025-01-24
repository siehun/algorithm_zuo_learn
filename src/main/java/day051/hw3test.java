package day051;

import java.io.*;

public class hw3test {
    public static void main(String[] args) throws IOException {
        int[] p = new int[]{
                18452, 96389, 81846, 92656, 62649, 60185, 23262 ,12055 ,96612, 3055 ,36453 ,37042, 58917, 22302, 74039 ,54569,
                17425, 53343, 61959, 99007, 22406, 82440, 97366, 80146, 45213 ,64546, 74121, 10272};
        int ans = f1(1, 99007, p);
        System.out.println(ans);
    }
    public static int f1(int l, int r, int[] part) {
        int ans = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (f(part, mid, 99007)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
    public static boolean f(int[] part, int mid, int max) {
        int cur = mid;
        for (int i = 0; i < part.length; i++) {
            if (part[i] < cur) {
                cur += (cur - part[i]);
            } else {
                cur -= (part[i] - cur);
            }
            if (cur < 0) {
                return false;
            }
            if (cur >= max) {
                return true;
            }
        }
        return true;
    }
}
