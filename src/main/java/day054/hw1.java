package day054;

public class hw1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] windows = new int[n];
        int l = 0, r = 0;
        int[] ans = new int[n - k + 1];
        int start = 0;
        for (int i = 0; i < n; i++) {
            while (l < r && nums[windows[r-1]] < nums[i]) {
                r--;
            }
            windows[r++] = i;
            if (i >= k - 1) {
                ans[start++] = nums[windows[l]];
                if (windows[l] == i - k + 1) {
                    l++;
                }
            }
        }
        return ans;
    }
}
