package day072;

import java.util.Scanner;

public class hw5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] right = right(arr);
        int ans = k;
        int len = 0;
        int[] ends = new int[n];
        for (int i = 0, j = k; j < n; i++, j++) {
            int find = bs2(ends, len, arr[j]);
            int left = find == -1 ? len : find;
            ans = Math.max(ans, left + k + right[j]);
            find = bs2(ends, len, arr[i]);
            if (find == -1) {
                ends[len++] = arr[i];
            } else {
                ends[find] = arr[i];
            }
        }
        ans = Math.max(ans, len + k);
        System.out.println(ans);
    }
    public static int[] right(int[] arr) {
        int n = arr.length;
        int len = 0;
        int[] ends = new int[n];
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int find = bs1(ends,len, arr[i]);
            if (find == -1) {
                ends[len++] = arr[i];
                res[i] = len;
            } else {
                ends[find] = arr[i];
                res[i] = find + 1;
            }
        }
        return res;
    }
    public static int bs1(int[] arr, int len, int num) {
        int l = 0, r = len - 1;
        int ans = -1;
        while (l <= r) {
             int mid = (l + r) / 2;
             if (arr[mid] < num) {
                 ans = mid;
                 r = mid - 1;
             } else {
                 l = mid + 1;
             }
        }
        return ans;
    }

    public static int bs2(int[] arr, int len, int num) {
        int l = 0, r = len - 1;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] > num) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
