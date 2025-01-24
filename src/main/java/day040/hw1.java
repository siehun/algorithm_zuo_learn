package day040;
// N皇后问题
// 测试链接 : https://leetcode.cn/problems/n-queens-ii/
public class hw1 {
    public int totalNQueens(int n) {
        // path进行记录，path[i]表示第i行放在path[i]的位置
        if (n < 1) {
            return 0;
        }
        int[] path = new int[n];
        return f(0, path);
    }
    public int f(int i, int[] path) {
        int n = path.length;
        if (i == n) {
            return 1;
        }
        int ans = 0;
        for (int j = 0; j < n; j++) {
            // 遍历这一行的每个格子
            if (check(i, j, path)) {
                path[i] = j;
                ans += f(i + 1, path);
            }
        }
        return ans;
    }
    public boolean check(int i, int j, int[] path) {
        // 遍历0 - i行，看这些格子的影响
        for (int k = 0; k < i; k++) {
            if (j == path[k] || Math.abs(k - i) == Math.abs(path[k] - j)) {
                return false;
            }
        }
        return true;
    }
    // 我们用位运算，三个限制，左，列，右，终止
    public int totalNQueens1(int n) {
        int limit = (1 << n ) - 1;
        int ans = f1(limit, 0, 0, 0);
        return ans;
    }
    public int f1(int limit, int col, int left, int right) {
        if (col == limit) {
            return 1;
        }
        int ban = col | left | right;
        int candidate = limit & (~ban);
        int ans = 0;
        while (candidate > 0) {
            int righone = candidate & (-candidate);
            candidate ^= righone;
            ans += f1(limit, col | righone, (left | righone) >> 1, (right | righone) << 1);
        }
        return ans;
    }

}
