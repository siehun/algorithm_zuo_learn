package day024;
// 无序数组中第K大的元素
// 测试链接 : https://leetcode.cn/problems/kth-largest-element-in-an-array/
public class hw1 {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int xi = n - k;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int xrandom = nums[l + (int)(Math.random()*(r - l + 1))];
            int[] record = partition2(nums, l, r, xrandom);
            if (xi < record[0]) {
                r = record[0] - 1;
            } else if (xi > record[1]) {
                l = record[1] + 1;
            } else {
                return xrandom;
            }
        }
        return -1;
    }
    public int[] partition2(int[] nums, int l, int r, int x) {
        int left = l;
        int right = r;
        for (int i = l; i <= right;) {
            if (nums[i] > x) {
                swap(nums, i, right--);
            } else if(nums[i] < x) {
                swap(nums,i++,left++);
            } else {
                i++;
            }
        }
        return new int[]{left, right};
    }
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
