package day065;

import java.util.Scanner;

public class hw2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] path = new int[m];
        for (int i = 0; i < m; i++) {
            path[i] = sc.nextInt();
        }
        int[][] matrix = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        for (int danger = 1; danger <= n; danger++){
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (matrix[i][j] > matrix[i][danger] + matrix[danger][j]) {
                        matrix[i][j] = matrix[i][danger] + matrix[danger][j];
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 1; i < m; i++) {
            ans += matrix[path[i - 1]][path[i]];
        }
        System.out.println(ans);
    }
}
