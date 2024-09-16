package day070;

public class hw5 {
    public int minCapability(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(nums[i], min);
            max= Math.max(nums[i], max);
        }
        int ans = 0;
        while(min <= max) {
            int mid = (min + max) / 2;
            if (rob1(nums, mid) >= k) {
                ans = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return ans;
    }
    public int rob1(int[] nums, int cap) {
        int len = nums.length;
        if (len == 1) {
            return nums[0] <= cap ? 1:0;
        }
        if (len == 2) {
            return (nums[0] <= cap || nums[1] <= cap) ? 1 : 0;
        }
        int prepre = nums[0] <= cap ? 1 : 0;
        int pre = (nums[0] <= cap || nums[1] <= cap) ? 1 : 0;
        for (int i = 2; i < len; i++) {
            int cur = Math.max(pre, (nums[i] <= cap ? 1 : 0) + prepre);
            prepre = pre;
            pre = cur;
        }
        return pre;
    }
    public int rob2(int[] nums, int cap) {
        int len = nums.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (cap >= nums[i]) {
                ans += 1;
                i++;
            }
        }
        return ans;
    }

}
