package day054;

import java.util.ArrayList;

public class hw2 {
    public final int MAXN = 100001;
    ArrayList<Integer> col = new ArrayList<>();
    public int minl= 0, minr=0, maxl=0, maxr=0;
    public int[] minque = new int[MAXN];
    public int[] maxque = new int[MAXN];
    public int[] arr;
    public int longestSubarray(int[] nums, int limit) {
        arr = nums;
        int n = nums.length;
        int ans = 0;
        for (int l = 0, r = 0; l < n; l++) {
            while (r < n && ok(nums[r], limit)) {
                push(r++);
            }
            ans = Math.max(ans,r - l);
            pop(l);
        }
        return ans;
    }
    public boolean ok(int val, int limit) {
        int min = minl < minr ? Math.min(arr[minque[minl]], val) : val;
        int max = maxl < maxr ? Math.max(arr[maxque[maxl]], val) : val;
        return max - min <= limit;
    }
    public void push(int i) {
        while (maxl < maxr && arr[maxque[maxr - 1]] <= arr[i]) {
            maxr--;
        }
        maxque[maxr++] = i;
        while (minl < minr && arr[minque[minr - 1]] >= arr[i]) {
            minr--;
        }
        minque[minr++] = i;
    }
    public void pop(int l) {
        if (maxl < maxr && maxque[maxl] == l) {
            maxl++;
        }
        if (minl < minr && minque[minl] == l) {
            minl++;
        }
    }

}
