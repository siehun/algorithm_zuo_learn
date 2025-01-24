package day048;
// 利用二维前缀和信息迅速得到二维区域和
// 测试链接 : https://leetcode.cn/problems/range-sum-query-2d-immutable/
public class hw1 {
    class NumMatrix {
        public int[][] col;
        public NumMatrix(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            col = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    col[i][j] = matrix[i - 1][j - 1];
                    col[i][j] = col[i - 1][j] + col[i][j - 1] - col[i - 1][j - 1] + col[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            row1+=1;
            col1+=1;
            row2+=1;
            col2+=1;
            return col[row2][col2] + col[row1 - 1][col1 - 1] - col[row1 - 1][col2] - col[row2][col1 -1];
        }
    }
}
