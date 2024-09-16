package day091;

import java.util.HashMap;

public class hw6 {
    // 暴力方法
    // 为了验证
    public static int len1(int[] arr) {
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int zero = 0;
            int one = 0;
            for (int j = i; j < arr.length; j++) {
                zero += arr[j] == 0 ? 1 : 0;
                one += arr[j] == 1 ? 1 : 0;
                map.putIfAbsent(zero, new HashMap<>());
                map.get(zero).put(one, map.get(zero).getOrDefault(one, 0) + 1);
            }
        }
        int ans = 0;
        for (int zeros : map.keySet()) {
            for (int ones : map.get(zeros).keySet()) {
                int num = map.get(zeros).get(ones);
                if (num > 1) {
                    ans = Math.max(ans, zeros + ones);
                }
            }
        }
        return ans;
    }

    // 正式方法
    // 时间复杂度O(n)
    public static int len2(int[] arr) {
        int leftZero = -1;
        int rightZero = -1;
        int leftOne = -1;
        int rightOne = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                leftZero = i;
                break;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                leftOne = i;
                break;
            }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 0) {
                rightZero = i;
                break;
            }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 1) {
                rightOne = i;
                break;
            }
        }
        int p1 = rightZero - leftZero;
        int p2 = rightOne - leftOne;
        return Math.max(p1, p2);
    }

    // 为了验证
    public static int[] randomArray(int len) {
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = (int) (Math.random() * 2);
        }
        return ans;
    }

    // 为了验证
    public static void main(String[] args) {
        int N = 500;
        int testTimes = 2000;
        System.out.println("测试开始");
        for (int i = 1; i <= testTimes; i++) {
            int n = (int) (Math.random() * N) + 2;
            int[] arr = randomArray(n);
            int ans1 = len1(arr);
            int ans2 = len2(arr);
            if (ans1 != ans2) {
                System.out.println("出错了!");
            }
            if (i % 100 == 0) {
                System.out.println("测试到第" + i + "组");
            }
        }
        System.out.println("测试结束");
    }


}
