package day070;

public class hw4 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        if (len == 3) {
            return Math.max(nums[0], Math.max(nums[1], nums[2]));
        }
        return Math.max(nums[0] + rob1(nums, 2, len - 2), rob1(nums, 1, len - 1));
    }
    public int rob1(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
        }
        if (r - l == 1) {
            return Math.max(nums[l], nums[r]);
        }
        int prepre = nums[l];
        int pre = Math.max(nums[l], nums[l + 1]);
        for (int i = l + 2; i <= r; i++) {
            int cur = Math.max(pre, nums[i] + prepre);
            prepre = pre;
            pre = cur;
        }
        return pre;
    }
}
