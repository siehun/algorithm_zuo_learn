package day006;

import java.util.Arrays;
// 有序数组中找>=num的最左位置

public class hw2 {
    public static void main(String[] args) {
        int N = 100;
        int V = 1000;
        int testTime = 500000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int n = (int) (Math.random() * N);
            int[] arr = randomArray(n, V);
            Arrays.sort(arr);
            int num = (int) (Math.random() * V);
            if (right(arr, num) != findLeft(arr, num)) {
                System.out.println("出错了!");
            }
        }
        System.out.println("测试结束");
    }

    // 为了验证
    public static int[] randomArray(int n, int v) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * v) + 1;
        }
        return arr;
    }

    // 为了验证
    // 保证arr有序，才能用这个方法
    public static int right(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= num) {
                return i;
            }
        }
        return -1;
    }

    // 保证arr有序，才能用这个方法

    // 数组从小到大排序
    public static int findLeft(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int l = 0, r = arr.length - 1;
        int ans = -1;
        while (l <= r) {
            int mid = r + ((l - r) >> 1);
            if (arr[mid] >= num) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
