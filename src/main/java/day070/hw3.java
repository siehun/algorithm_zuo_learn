package day070;

public class hw3 {
    public int maxSubarraySumCircular(int[] nums) {
        int len = nums.length;
        int maxsum = nums[0];
        int minsum = nums[0];
        int premin = nums[0];
        int premax = nums[0];
        int total = nums[0];
        for (int i = 1; i < len; i++) {
            premax = Math.max(premax + nums[i], nums[i]);
            maxsum = Math.max(maxsum, premax);
            total += nums[i];
            premin = Math.min(premin + nums[i], nums[i]);
            minsum = Math.min(minsum, premin);
        }
        return minsum == total ? maxsum:Math.max(total - minsum, maxsum);
    }
}
