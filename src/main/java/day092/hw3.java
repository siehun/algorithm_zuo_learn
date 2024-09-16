package day092;

import java.util.Arrays;

public class hw3 {
    public long makeSimilar(int[] nums, int[] target) {
        int n = nums.length;
        int oddsize = f(nums);
        f(target);
        Arrays.sort(nums, 0, oddsize);
        Arrays.sort(nums,oddsize, n);
        Arrays.sort(target, 0, oddsize);
        Arrays.sort(target, oddsize, n);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.abs((long)nums[i] - target[i]);
        }
        return ans / 4;


    }
    public int f(int[] arr) {
        int len = arr.length;
        int left = -1;
        for (int i = 0; i < len;i++) {
            if ((arr[i] & 1) == 1) {
                swap(arr, ++left, i);
            }
        }
        return left + 1;
    }
    public void swap(int[] arr,int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
