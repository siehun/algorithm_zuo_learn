package day070;

public class hw2 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        int ans = Math.max(dp[0], dp[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(nums[i] + dp[i - 2], nums[i]));
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }
    public int rob1(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int prepre = nums[0];
        int pre = Math.max(nums[0], nums[1]);
        int ans = Math.max(pre, prepre);
        for (int i = 2; i < len; i++) {
            int cur = Math.max(pre, Math.max(nums[i] + prepre, nums[i]));
            ans = Math.max(ans, cur);
            prepre = pre;
            pre = cur;
        }
        return ans;
    }
}
