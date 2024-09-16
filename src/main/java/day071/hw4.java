package day071;

public class hw4 {
    public static int[] maxSumOfThreeSubarray(int[] nums, int k) {
        int n = nums.length;
        // sums[i]以i开头长度为k的子数组的累加和
        int[] sums = new int[n];
        for (int l = 0,r = 0, sum = 0; r < n; r++) {
            sum += nums[r];
            if (r - l + 1 == k) {
                sums[l] = sum;
                sum -= nums[l];
                l++;
            }
        }
        // prefix[i]:0-i上长度为k的子数组中，最大累加和是以什么位置开头的
        int[] prefix = new int[n];
        for (int l = 1, r = k; r < n; l++, r++) {
            if (sums[l] > sums[prefix[r - 1]]) {
                prefix[r] = l;
            } else {
                prefix[r] = prefix[r - 1];
            }
        }
        // suffix[i]:i - n-1上拥有最大累加和的子数组， 是以什么位置开头的
        int[] suffix = new int[n];
        suffix[n - k] = n - k;
        for (int l = n - k  - 1; l >= 0; l--) {
            if (sums[l] >= sums[suffix[l + 1]]) {
                suffix[l] = l;
            } else {
                suffix[l] = suffix[l + 1];
            }
        }
        int a = 0, b = 0, c = 0, max = 0;
        for (int i = k, j = 2 * k - 1; j < n - k; i++, j++) {
            int p = prefix[i - 1];
            int s = suffix[j + 1];
            int sum = sums[p] + sums[i] + sums[s];
            if (sum > max) {
                max = sum;
                a = p;
                b = i;
                c = s;
            }
        }
        return new int[]{a , b, c};
    }
}
