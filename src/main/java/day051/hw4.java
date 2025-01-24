package day051;

import java.util.Arrays;

// 找出第K小的数对距离
// 数对 (a,b) 由整数 a 和 b 组成，其数对距离定义为 a 和 b 的绝对差值。
// 给你一个整数数组 nums 和一个整数 k
// 数对由 nums[i] 和 nums[j] 组成且满足 0 <= i < j < nums.length
// 返回 所有数对距离中 第 k 小的数对距离。
// 测试链接 : https://leetcode.cn/problems/find-k-th-smallest-pair-distance/
public class hw4 {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0;
        int r = nums[n - 1] - nums[0];
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (f(nums, mid) >= k) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        }
        return ans;
    }
    public int f(int[] nums, int mid) {
        int ans = 0;
        for (int l = 0, r = 0; l < nums.length; l++) {
            while (r + 1 < nums.length && nums[r + 1] - nums[l] <= mid) {
                r++;
            }
            ans += (r - l);
        }
        return ans;
    }
}
