package day048;
// 边框为1的最大正方形
// 给你一个由若干 0 和 1 组成的二维网格 grid
// 请你找出边界全部由 1 组成的最大 正方形 子网格
// 并返回该子网格中的元素数量。如果不存在，则返回 0。
// 测试链接 : https://leetcode.cn/problems/largest-1-bordered-square/
public class hw2 {
    public int largest1BorderedSquare(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] temp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                temp[i][j] = grid[i - 1][j - 1];
            }
        }
        presum(temp, n, m);
        if (temp[n][m] == 0) {
            return 0;
        }
        int ans = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int c = i + ans, d = j + ans, k = ans + 1; c <= n && d <=m; c++, d++, k++) {
                    int a = count(temp, c, d, i, j );
                    int b = count(temp,   c - 1,d - 1, i + 1, j + 1);
                    if(a - b == 4 * (k - 1)) {
                        ans = k;
                    }

                }
            }
        }
        return ans * ans;

    }
    public int count(int[][] temp, int i, int j, int a, int b) {
        return temp[i][j] - temp[i][b - 1] - temp[a - 1][j] + temp[a - 1][b - 1];
    }
    public void presum(int[][] temp, int n, int m) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                temp[i][j] += (temp[i - 1][j] + temp[i][j - 1] - temp[i - 1][j -1]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        hw2 hw = new hw2();
        int res = hw.largest1BorderedSquare(grid);
        System.out.println(res);
    }
}
