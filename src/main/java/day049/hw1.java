package day049;
// 累加和大于等于target的最短子数组长度
// 给定一个含有 n 个正整数的数组和一个正整数 target
// 找到累加和 >= target 的长度最小的子数组并返回其长度
// 如果不存在符合条件的子数组返回0
// 测试链接 : https://leetcode.cn/problems/minimum-size-subarray-sum/
public class hw1 {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        for (int l = 0, r = 0; r < n; r++) {
            sum += nums[r];
            while (sum - nums[l] >= target) {
                sum -= nums[l];
                l++;
            }
            if (sum >= target) {
                ans = Math.min(ans, r - l + 1);
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
