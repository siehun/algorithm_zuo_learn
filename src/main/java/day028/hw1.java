package day028;

import java.util.Arrays;

// 基数排序
// 测试链接 : https://leetcode.cn/problems/sort-an-array/
public class hw1 {
    // 计数排序
    //假设在0-10之间，只需一个一个统计在取出来即可


    public static int BASE = 10;
    public static int MAXN = 50001;
    public static int[] help = new int[MAXN];
    public static int[] cnts = new int[BASE];

    public static int bits(int number) {
        int ans = 0;
        while (number > 0) {
            number /= BASE;
            ans++;
        }
        return ans;
    }
    public static int[] sortArray(int[] arr) {
        if (arr.length > 1) {
            int n = arr.length;
            int min = arr[0];
            for (int i = 1; i < n; i++) {
                min = Math.min(min, arr[i]);
            }
            int max = 0;
            for (int i = 0; i < n; i++) {
                arr[i] -= min;
                max = Math.max(max, arr[i]);
            }
            radixSort(arr, n, bits(max));
            for (int i = 0; i < n; i++) {
                arr[i] += min;
            }
        }
        return arr;
    }
    // 基数排序核心代码
    // arr内要保证没有负数
    // n是arr的长度
    // bits是arr中最大值在BASE进制下有几位
    public static void radixSort(int[] arr, int n,  int bits) {
        for (int offset = 1; bits > 0; offset *= BASE, bits--) {
            Arrays.fill(cnts, 0);
            for (int i = 0; i < n; i++) {
                cnts[(arr[i] / offset) % BASE]++;
            }
            //处理成前缀和
            for (int i = 1; i < BASE; i++) {
                cnts[i] = cnts[i - 1] + cnts[i];
            }
            // 进行分区
            for (int i = n - 1; i >= 0; i--) {
                help[--cnts[(arr[i] / offset) % BASE]] = arr[i];
            }

            //
            for (int i = 0; i < n; i++) {
                arr[i] = help[i];
            }
        }
    }
}
