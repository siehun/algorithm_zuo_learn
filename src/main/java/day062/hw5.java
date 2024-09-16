package day062;

import java.util.PriorityQueue;

public class hw5 {
    public int[] move = new int[]{-1, 0, 1, 0, -1};
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        int[][] record = new int[m][n];
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    heap.add(new int[]{i, j, heightMap[i][j]});
                    visited[i][j] = true;
                }
            }
        }

        while (!heap.isEmpty()) {
            int[] cur = heap.poll();
            int x = cur[0];
            int y = cur[1];
            int w = cur[2];
            for (int i = 0; i < 4; i++) {
                int fx = x + move[i];
                int fy = y + move[i + 1];
                if (fx >= 0 && fx < m && fy >= 0 && fy < n && !visited[fx][fy]) {
                    visited[fx][fy] = true;
                    if (heightMap[fx][fy] >= w) {
                        record[fx][fy] = 0;
                        heap.add(new int[]{fx, fy, heightMap[fx][fy]});
                    } else {
                        record[fx][fy] = w - heightMap[fx][fy];
                        heap.add(new int[]{fx, fy, w});
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans += record[i][j];
            }
        }
        return ans;
    }
}
