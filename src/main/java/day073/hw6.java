package day073;

import java.util.ArrayList;
import java.util.*;

public class hw6 {
    // 给定一个非负数组，返回子序列中累加和的最小前k个累加和
    // 为了测试
    public static int[] topKSum1(int[] nums, int k) {
        ArrayList<Integer> allSubsequences = new ArrayList<>();
        f1(nums, 0, 0, allSubsequences);
        allSubsequences.sort((a, b) ->a.compareTo(b));
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = allSubsequences.get(i);
        }
        return ans;
    }
    // 暴力方法拿到所有子序列的前k个和，再排序
    public static void f1(int[] nums, int index, int sum, ArrayList<Integer> arr) {
        if (index == nums.length) {
            arr.add(sum);
        } else {
            f1(nums, index+1, sum, arr);
            f1(nums, index+1, sum+nums[index], arr);
        }
    }
    // 01背包
    public static int[] topKSum2(int[] nums, int k) {
        // dp[i][j]表示前i个数，累加和严格等于j的个数
        // 为j做准备
        int sum = 0;
        int n = nums.length;
        for (int num : nums) {
            sum += num;
        }
        // 0代表一个数也不选
        int[][] dp = new int[n + 1][sum + 1];
        //空集也表示一个数
        dp[0][0] = 1;
        //从第一个数开始遍历
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - nums[i - 1] >= 0) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        int[] ans = new int[k];
        int index = 0;
        for (int j = 0; j<= sum && index <k; j++) {
            for (int i = 0; i < dp[n][j] && index <k; i++) {
                ans[index++] = j;
            }
        }
        return ans;
    }
    public static int[] topKSum3(int[] nums, int k) {
        Arrays.sort(nums);
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)->a[1] -b[1]);
        heap.add(new int[] {0, nums[0]});
        int[] ans = new int[k];
        for (int i = 1; i <k ;i++) {
            int[] cur = heap.poll();
            int right = cur[0];
            int sum = cur[1];
            ans[i] = sum;
            if (right + 1 < nums.length) {
                heap.add(new int[]{right + 1, sum - nums[right] + nums[right + 1]});
                heap.add(new int[]{right+1,sum +nums[right+1]});
            }
        }
        return ans;
    }
    public static int[] randomArray(int len, int value) {
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = (int) (Math.random() * value);
        }
        return ans;
    }

    // 为了测试
    public static boolean equals(int[] ans1, int[] ans2) {
        if (ans1.length != ans2.length) {
            return false;
        }
        for (int i = 0; i < ans1.length; i++) {
            if (ans1[i] != ans2[i]) {
                return false;
            }
        }
        return true;
    }

    // 为了测试
    // 对数器
    public static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int n = 15;
        int v = 40;
        int testTime = 5000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int len = (int) (Math.random() * n) + 1;
            int[] nums = randomArray(len, v);
            int k = (int) (Math.random() * ((1 << len) - 1)) + 1;
            int[] ans1 = topKSum1(nums, k);
            int[] ans2 = topKSum2(nums, k);
            int[] ans3 = topKSum3(nums, k);
            if (!equals(ans1, ans2) || !equals(ans1, ans3)) {
                System.out.println("出错了！");
            }
//            if (!equals(ans1, ans2)) {
//                System.out.println("出错了！");
//            }
        }
        System.out.println("测试结束");
    }

}
