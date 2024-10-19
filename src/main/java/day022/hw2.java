package day022;

import java.io.BufferedInputStream;
import java.util.Scanner;
// 翻转对数量
// 测试链接 : https://leetcode.cn/problems/reverse-pairs/
public class hw2 {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return 0;
        }
        int ans = count(0, n - 1, nums);
        return ans;
    }
    public int count(int l, int r, int[] arr) {
        if (l >= r) {
            return 0;
        }
        int m = r + ((l - r) >> 1);
        return count(l, m, arr) + count(m + 1, r, arr) + merge(arr, l, m, r);
    }
    public int merge(int[] arr, int l, int m , int r) {
        int ans = 0;
        int total = 0;
        for (int i = l, j = m + 1; i <= m; i++) {
            while (j <= r && (long)arr[i] >(long)2 * arr[j]) {
                total++;
                j++;
            }
            ans += total;
        }
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = m + 1;
        int i = 0;
        while (p1 <= m && p2 <= r) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < r - l + 1; j++) {
            arr[j+l] = help[j];
        }
        return ans;
    }
}
