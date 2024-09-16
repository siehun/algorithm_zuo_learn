package day072;

import java.util.Arrays;

public class hw2 {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes,(a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] cur = new int[n];
        for (int i = 0; i < n; i++) {
            cur[i] = envelopes[i][1];
        }
        int[] ends = new int[n];
        ends[0] = cur[0];
        int size = 1;
        for (int i = 1; i < n; i++) {
            int find = find(cur[i], ends, size);
            if (find == -1) {
                ends[size++] = cur[i];
            } else {
                ends[find] = cur[i];
            }
        }
        return size;

    }
    public int find(int num, int[] cur, int len) {
        int l = 0;
        int r = len - 1;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (cur[mid] >= num) {
                ans= mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
