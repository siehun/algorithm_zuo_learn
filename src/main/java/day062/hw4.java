package day062;

import java.util.ArrayDeque;

public class hw4 {
    public int[][] move = new int[][] {{},{0,1},{0,-1},{1, 0},{-1, 0}};
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] distance = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        distance[0][0] = 0;
        deque.add(new int[]{0,0});
        while(!deque.isEmpty()) {
            int[] cur = deque.pollFirst();
            int x = cur[0];
            int y = cur[1];
            if (x == m - 1 && y == n - 1) {
                return distance[x][y];
            }
            int mov = grid[x][y];
            for (int i = 1; i <= 4; i++) {
                int cost = i == mov ? 0 : 1;
                int nx = x + move[i][0];
                int ny = y + move[i][1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && distance[x][y] + cost < distance[nx][ny]) {
                    distance[nx][ny] = distance[x][y] + cost;
                    if (cost == 0) {
                        deque.addFirst(new int[]{nx, ny});
                    } else {
                        deque.addLast(new int[]{nx, ny});
                    }
                }
            }
        }
        return -1;
    }
}
