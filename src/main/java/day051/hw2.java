package day051;
// 分割数组的最大值(画匠问题)
// 给定一个非负整数数组 nums 和一个整数 m
// 你需要将这个数组分成 m 个非空的连续子数组。
// 设计一个算法使得这 m 个子数组各自和的最大值最小。
// 测试链接 : https://leetcode.cn/problems/split-array-largest-sum/
public class hw2 {
    public int splitArray(int[] nums, int k) {
        int l = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int r = sum;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (f(nums, mid) <= k) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
    public int f(int[] nums, int cur) {
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > cur) {
                return Integer.MAX_VALUE;
            }
            if (sum + nums[i] > cur) {
                ans++;
                sum = 0;
            }
            sum += nums[i];
        }
        if (sum > 0) {
            ans++;
        }
        return ans;
    }
}
