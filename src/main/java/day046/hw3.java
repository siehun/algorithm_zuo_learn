package day046;

import java.util.HashMap;

// 返回无序数组中累加和为给定值的子数组个数
// 测试链接 : https://leetcode.cn/problems/subarray-sum-equals-k/
public class hw3 {
    public int subarraySum(int[] nums, int k) {
        // 思路：前缀和处理
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1]  + nums[i];
        }
        // 进行相减
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int total = 0;
        for (int i = 0; i < n; i++) {
            int aim = sum[i] - k;
            if (map.containsKey(aim)) {
                total += map.get(aim);
            }
            if (map.containsKey(sum[i])) {
                map.put(sum[i], map.get(sum[i]) + 1);
            } else {
                map.put(sum[i], 1);
            }
        }
        return total;
    }
}
