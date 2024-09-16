package day006;

import java.util.Arrays;

public class hw1 {
    // 二分搜索某个数是否存在
    // 为了验证
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
            if (right(arr, num) != exist(arr, num)) {
                System.out.println("出错了!");
            }
        }
        System.out.println("测试结束");
    }

    // 数组从小到大排序
    private static boolean exist(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = r + ((l - r) >> 1);
            if (arr[mid] > num) {
                 r = mid - 1;
            } else if (arr[mid] < num) {
                l = mid + 1;
            } else {
                return true;
            }
        }
        return false;
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
    public static boolean right(int[] sortedArr, int num) {
        for (int cur : sortedArr) {
            if (cur == num) {
                return true;
            }
        }
        return false;
    }

}
