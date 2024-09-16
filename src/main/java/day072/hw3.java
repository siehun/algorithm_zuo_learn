package day072;

public class hw3 {
    public int kIncreasing(int[] arr, int k) {
        int n = arr.length;
        int ans = 0;
        for (int i = 0; i < k; i++) {
            int[] nums = new int[n];
            int size = 0;
            for (int j = i; j < n; j += k) {
                nums[size++] = arr[j];
            }
            ans += size - f(nums, size);
        }
        return ans;
    }
    public int bs(int len, int[] arr, int num) {
        int l = 0;
        int r = len - 1;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] > num) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
    public int f(int[] nums,int si) {
        int n = si;
        int[] ends = new int[n];
        int size = 0;
        for (int i = 0; i < n; i++) {
            int find = bs(size, ends, nums[i]);
            if (find == -1) {
                ends[size++] = nums[i];
            } else {
                ends[find] = nums[i];
            }
        }
        return size;
    }
}
