package day076;

public class hw2 {
    public boolean predictTheWinner(int[] nums) {
        int total_score = 0;
        int n = nums.length;
        for (int num : nums) {
            total_score += num;
        }
        int score1 = f(nums ,0, n - 1, 0);
        return score1 >= (total_score - score1);
    }
    public int f(int[] nums, int l, int r, int score) {
        if (l == r) {
            return score += nums[l];
        }
        if (l + 1 == r) {
            return score += Math.max(nums[l], nums[r]);
        }
        int left = Math.min(f(nums, l + 1, r - 1, score + nums[l]), f(nums, l + 2, r , score + nums[l]));
        int right = Math.min(f(nums, l + 1, r - 1, score + nums[r]), f(nums, l, r - 2, score + nums[r]));
        return Math.max(left, right);
    }

}
