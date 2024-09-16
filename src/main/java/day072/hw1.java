package day072;

public class hw1 {
    public int lengthOfLIS(int[] nums) {
        int ans = 1;
        int n = nums.length;
        int[] record = new int[n];
        record[0] = 1;
        for (int i = 1; i < n; i++) {
            int cur = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    cur = Math.max(cur, record[j] + 1);
                }
            }
            record[i] = cur;
            ans = Math.max(ans, cur);
        }
        return ans;
    }
    public int lengthOfLIS1(int[] nums) {
        int n = nums.length;
        int[] ends = new int[n];
        int len = 0;
        for (int i = 0; i < n; i++) {
            int find = bs1(ends, len, nums[i]);
            if (find == -1) {
                ends[len++] = nums[i];
            } else {
                ends[find] = nums[i];
            }
        }
        return len;
    }
    public int bs1(int[] ends, int len , int val) {
        int l = 0, r = len - 1;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (ends[mid] >= val) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
    public int bs2(int[] ends, int len , int val) {
        int l = 0, r = len - 1;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (ends[mid] > val) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
