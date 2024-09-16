package day06;

public class hw4 {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[len - 1] > nums[len - 2]) {
            return len - 1;
        }
        int l = 1;
        int r = len - 2;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (f(nums,mid) == 0) {
                return mid;
            } else if (f(nums, mid) == 1) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
    public int f(int[] nums, int t) {
        if (nums[t] > nums[t - 1] && nums[t] > nums[t + 1]) {
            return 0;
        }
        if (nums[t] < nums[t - 1]) {
            return -1;
        }
        if (nums[t] < nums[t + 1]) {
            return 1;
        }
        return -1;
    }
}
