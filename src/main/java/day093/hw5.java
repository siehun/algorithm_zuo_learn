package day093;

public class hw5 {
    public int findMinMoves(int[] machines) {
        int n = machines.length;
        int[] left = new int[n];
        left[0] = machines[0];
        int[] right = new int[n];
        right[n - 1] = machines[n - 1];
        int sum = machines[0];
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] + machines[i];
            sum += machines[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] + machines[i];
        }
        int ans = 0;
        int cur = 0;
        int avg = sum / n;
        if (avg * n != sum) {
            return -1;
        }
        for (int i = 0; i < n; i++) {
            int leftneed = i * avg - ((i > 0) ? left[i - 1] : 0);
            int rightneed = (n - i - 1) * avg - ((i + 1 >= n) ? 0 : right[i + 1]);
            if (leftneed > 0 && rightneed >0) {
                cur = leftneed + rightneed;
            } else {
                cur = Math.max(Math.abs(leftneed), Math.abs(rightneed));
            }
            ans = Math.max(ans, cur);
        }
        return ans;

    }
}
