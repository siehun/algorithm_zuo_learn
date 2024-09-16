package day092;

public class hw5 {
    public boolean canDivideIntoSubsequences(int[] nums, int k) {
        int cnt = 1;
        int maxcnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                maxcnt = Math.max(cnt , maxcnt);
                cnt = 1;
            } else {
                cnt++;
            }
        }
        maxcnt = Math.max(cnt ,maxcnt);
        return nums.length / maxcnt >= k;
    }
}
