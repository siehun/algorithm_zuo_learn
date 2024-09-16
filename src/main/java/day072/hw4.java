package day072;

import java.util.Arrays;

public class hw4 {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Arrays.sort(pairs, (a, b) -> (a[1] - b[1]));
        int cur = -1001;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int start = pairs[i][0];
            int end =  pairs[i][1];
            if (start > cur) {
                ans++;
                cur = end;
            }
        }
        return ans;
    }
    public int findLongestChain1(int[][] pairs) {
        int n = pairs.length;
        Arrays.sort(pairs, (a, b)-> (a[0] - b[0]));
        int[] ends = new int[n];
        int len = 0;
        for (int[] pair : pairs) {
            int s = pair[0];
            int e = pair[1];
            int find = bs(ends, len, s);
            if (find == -1) {
                ends[len++] = e;
            } else {
                ends[find] = Math.min(ends[find], e);
            }
        }
        return len;
    }
    public int bs(int[] ends, int len, int num) {
        int l = 0, r = len - 1;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (ends[mid] >= num) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
