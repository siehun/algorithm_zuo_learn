package day093;

public class hw2 {
    public int minTaps(int n, int[] ranges) {
        int[] right = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int start = Math.max(0, i - ranges[i]);
            right[start] = Math.max(right[start], i + ranges[i]);
        }
        int ans = 0;
        int cur = 0;
        int next = 0;
        for (int i = 0; i < n; i++) {
            next = Math.max(next, right[i]);
            if (i == cur) {
                if (next > i) {
                    cur = next;
                    ans++;
                } else {
                    return -1;
                }
            }
        }
        return ans;
    }
}
