package day050;
// 按奇偶排序数组II
// 给定一个非负整数数组 nums。nums 中一半整数是奇数 ，一半整数是偶数
// 对数组进行排序，以便当 nums[i] 为奇数时，i也是奇数
// 当 nums[i] 为偶数时， i 也是 偶数
// 你可以返回 任何满足上述条件的数组作为答案
// 测试链接 : https://leetcode.cn/problems/sort-array-by-parity-ii/
public class hw1 {
    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a]= arr[b];
        arr[b] = temp;
    }
    public int[] sortArrayByParityII(int[] nums) {
        int odd = 1;
        int even = 0;
        int end = nums.length - 1;
        while (odd <= end && even <= end) {
            if (nums[end] % 2 == 0) {
                swap(nums, end, even);
                even += 2;
            } else {
                swap(nums, end, odd);
                odd += 2;

            }
        }
        return nums;
    }
}
