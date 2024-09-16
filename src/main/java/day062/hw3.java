package day062;

import java.util.ArrayDeque;
import java.util.HashSet;

public class hw3 {
    public int[] move = new int[] {-1, 0, 1, 0 , -1 };
    public int minimumObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = Integer.MAX_VALUE;
            }
        }
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.addFirst(new int[]{0, 0});
        ans[0][0] = 0;
        while (!deque.isEmpty()) {
            int[] cur = deque.pollFirst();
            if (cur[0] == n - 1 && cur[1] == m - 1) {
                return ans[n - 1][m - 1];
            }
            for (int i = 0; i < 4; i++) {
                int x = cur[0] + move[i];
                int y = cur[1] + move[i + 1];
                if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] + ans[cur[0]][cur[1]] < ans[x][y]) {
                    ans[x][y] = grid[x][y] + ans[cur[0]][cur[1]];
                    if (grid[x][y] == 0) {
                        deque.addFirst(new int[]{x, y});
                    } else {
                        deque.addLast(new int[]{x, y});
                    }
                }
            }
        }
        return ans[n - 1][m - 1];
    }
}
