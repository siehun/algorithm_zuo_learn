package day050;
// 缺失的第一个正数
// 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
// 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
// 测试链接 : https://leetcode.cn/problems/first-missing-positive/
public class hw7 {
    public int firstMissingPositive(int[] nums) {
        // 1- n + 1
        int l = 0;
        int r = nums.length;
        while (l < r) {
            if (nums[l] == l + 1) {
                l++;
            } else if (nums[l] > r || nums[l] <= l || nums[l] == nums[nums[l]-1]) {
                swap(nums, l, --r);
            } else {
                swap(nums, l, nums[l] - 1);
            }
        }
        return l +1;
    }
    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
