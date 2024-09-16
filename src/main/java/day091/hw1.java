package day091;

public class hw1 {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;

        int max = nums[0];
        int left = -1;
        for (int i = 1; i < len; i++) {
            if (max > nums[i]) {
                left = i;
            }
            max = Math.max(max, nums[i]);
        }
        int right = len;
        int min = nums[len - 1];
        for (int j = len - 1; j >= 0; j--) {
            if (min < nums[j]) {
                right = j;
            }
            min = Math.min(min,nums[j]);
        }
        return Math.max(0, left - right + 1);

    }
}
