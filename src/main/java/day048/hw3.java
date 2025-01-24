package day048;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

// 二维差分模版(洛谷)
// 测试链接 : https://www.luogu.com.cn/problem/P3397
// 请同学们务必参考如下代码中关于输入、输出的处理
public class hw3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            int n = (int)in.nval;in.nextToken();
            int m = (int)in.nval;
            int[][] matrix = new int[n + 2][n + 2];
            for (int i = 0; i < m; i++) {
                in.nextToken(); int a = (int)in.nval;
                in.nextToken(); int b = (int)in.nval;
                in.nextToken(); int c = (int)in.nval;
                in.nextToken(); int d = (int)in.nval;
                matrix[a][b] += 1;
                matrix[c + 1][d + 1] += 1;
                matrix[a][d + 1] += -1;
                matrix[c + 1][b] += -1;

            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1;j <= n; j++) {
                    matrix[i][j] = matrix[i][j] + matrix[i - 1][j] + matrix[i][j - 1] - matrix[i - 1][j - 1];
                    if (j == n) {
                        out.println(matrix[i][j]);
                    } else {
                        out.print(matrix[i][j] + " ");
                    }
                }
            }
        }
        out.flush();
        br.close();
        out.close();
    }
}
