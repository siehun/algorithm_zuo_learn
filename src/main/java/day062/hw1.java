package day062;

public class hw1 {
    public static int MAXN = 101;
    public static int[][] que = new int[MAXN * MAXN][2];
    public static int l , r;
    public static boolean[][] visited = new boolean[MAXN][MAXN];
    public static int[] move = new int[] {-1, 0, 1, 0, -1};
    public static int maxDistance(int[][] grid) {
        l = r = 0;
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    visited[i][j] = true;
                    que[r][0] = i;
                    que[r++][1] = j;
                    cnt++;
                } else {
                    visited[i][j] = false;
                }
            }
        }
        if (cnt == 0 || cnt == n * m) {
            return -1;
        }
        int level = 0;
        while (l < r) {
            level++;
            int size = r - l;
            for (int i = 0; i < size; i++) {
                int row = que[l][0];
                int col = que[l++][1];
                for (int j = 0; j < 4; j++) {
                    int a = row + move[j];
                    int b = col + move[j + 1];
                    if (a >= 0 && a < n && b >= 0 && b < m && !visited[a][b]) {
                        visited[a][b] = true;
                        que[r][0] = a;
                        que[r++][1] = b;
                    }
                }
            }

        }
        return level - 1;

    }
}
