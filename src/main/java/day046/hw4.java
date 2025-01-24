package day046;
// 返回无序数组中正数和负数个数相等的最长子数组长度
// 给定一个无序数组arr，其中元素可正、可负、可0
// 求arr所有子数组中正数与负数个数相等的最长子数组的长度
// 测试链接 : https://www.nowcoder.com/practice/545544c060804eceaed0bb84fcd992fb

import java.util.HashMap;
import java.util.Scanner;

public class hw4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num > 0) {
                arr[i] = 1;
            } else if (num < 0) {
                arr[i] = -1;
            } else {
                arr[i] = 0;
            }
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxlen = 0;
        for (int i = 0, sum = 0; i < n; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                maxlen = Math.max(maxlen, i - map.get(sum));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        System.out.println(maxlen);
    }
}
