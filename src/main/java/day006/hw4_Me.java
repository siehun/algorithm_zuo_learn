package day006;
// 峰值元素是指其值严格大于左右相邻值的元素
// 给你一个整数数组 nums，已知任何两个相邻的值都不相等
// 找到峰值元素并返回其索引
// 数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
// 你可以假设 nums[-1] = nums[n] = 无穷小
// 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
// 测试链接 : https://leetcode.cn/problems/find-peak-element/
// 测试链接 : https://leetcode.com/problems/find-peak-element/
public class hw4_Me {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[len - 1] > nums[len - 2]) {
            return len - 1;
        }
        int l = 1;
        int r = len - 2;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (f(nums,mid) == 0) {
                return mid;
            } else if (f(nums, mid) == 1) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
    public int f(int[] nums, int t) {
        if (nums[t] > nums[t - 1] && nums[t] > nums[t + 1]) {
            return 0;
        }
        if (nums[t] < nums[t - 1]) {
            return -1;
        }
        if (nums[t] < nums[t + 1]) {
            return 1;
        }
        return -1;
    }
}
