package day070;

public class hw1 {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] record = new int[len];
        int ans = nums[0];
        record[0] = nums[0];
        for (int i = 1; i < len; i++) {
            record[i] = Math.max(nums[i], nums[i] + record[i - 1]);
            ans = Math.max(ans, record[i]);
        }
        return ans;
    }
    public int maxSubArray1(int[] nums) {
        int len = nums.length;
        int pre = nums[0];
        int ans = pre;
        for (int i = 1; i < len; i++) {
            pre = Math.max(nums[i], nums[i] + pre);
            ans = Math.max(pre, ans);
        }
        return ans;
    }
    public static int left;
    public static int right;
    public static int sum;
    public static void extra(int[] nums) {
        sum = Integer.MIN_VALUE;
        for (int l = 0, r = 0, pre = Integer.MIN_VALUE; r < nums.length; r++) {
            if (pre >= 0) {
                pre += nums[r];
            } else {
                pre = nums[r];
                l = r;
            }
            if (pre > sum) {
                sum = pre;
                left = l;
                right = r;
            }
        }
    }
}
