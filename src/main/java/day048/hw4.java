package day048;
// 用邮票贴满网格图
// 给你一个 m * n 的二进制矩阵 grid
// 每个格子要么为 0 （空）要么为 1 （被占据）
// 给你邮票的尺寸为 stampHeight * stampWidth
// 我们想将邮票贴进二进制矩阵中，且满足以下 限制 和 要求 ：
// 覆盖所有空格子，不覆盖任何被占据的格子
// 可以放入任意数目的邮票，邮票可以相互有重叠部分
// 邮票不允许旋转，邮票必须完全在矩阵内
// 如果在满足上述要求的前提下，可以放入邮票，请返回 true ，否则返回 false
public class hw4 {
    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] g = new int[m + 2][n + 2];
        int[][] matrix = new int[m + 2][n + 2];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                g[i][j] = grid[i - 1][j - 1];
            }
        }
        // 前缀和
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                g[i][j] = g[i][j] + g[i - 1][j] + g[i][j - 1] - g[i - 1][j -1];
            }
        }
        // 对每个0位置进行遍历，看是否能贴邮票
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int c = i + stampHeight - 1;
                int d = j + stampWidth - 1;
                if (grid[i][j] == 0 && c < m && d < n) {
                    if (g[c + 1][d + 1] - g[i][d + 1] - g[c + 1][j] + g[i][j] == 0) {
                        matrix[i + 1][j + 1] += 1;
                        matrix[c + 2][d + 2] += 1;
                        matrix[c + 2][j + 1] -= 1;
                        matrix[i + 1][d + 2] -= 1;
                    }
                }
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                matrix[i][j] = matrix[i][j] + matrix[i - 1][j] + matrix[i][j - 1] - matrix[i - 1][j - 1];
            }
        }

        // 是否所有位置已经贴完
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && matrix[i + 1][j + 1] <= 0) {
                    return false;
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 0, 0,  0},{1, 0, 0, 0}, {1, 0, 0,  0}, {1, 0, 0, 0}, {1, 0, 0, 0}};
        hw4 hw = new hw4();
        hw.possibleToStamp(matrix, 4, 3);

    }
}
