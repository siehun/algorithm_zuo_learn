package day022;

import java.io.BufferedInputStream;
import java.util.Scanner;

// 最小和问题
// 测试链接 : https://www.nowcoder.com/practice/edfe05a1d45c4ea89101d936cac32469
public class hw1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        long ans =  smallSum(0, n - 1, arr);
        System.out.println(ans);
    }
    public static long smallSum(int l, int r, int[] arr) {
        if (l >= r) {
            return 0;
        }
        int m = r + ((l - r) >> 1);
        return smallSum(l, m, arr) + smallSum(m + 1, r, arr) + merge(arr, l, m, r);
    }
    public static long merge(int[] arr, int l, int m , int r) {
        long ans = 0;
        long sum = 0;
        // 右部分遍历一遍， 左部分进行滑动， 进行结算
        for (int i = l, j = m + 1; j <= r; j++) {
            while (i <= m && arr[i] <= arr[j]) {
                sum += arr[i++];
            }
            ans += sum;
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
