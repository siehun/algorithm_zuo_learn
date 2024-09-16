package day071;

public class hw1 {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int min = nums[0];
        int max = nums[0];
        int ans = nums[0];
        for (int i = 1; i < len; i++) {
            int curmin = Math.min(nums[i], Math.min(min * nums[i], max * nums[i]));
            int curmax = Math.max(nums[i], Math.max(min * nums[i], max * nums[i]));
            ans = Math.max(ans, curmax);
            min = curmin;
            max = curmax;
        }
        return ans;
    }
}
