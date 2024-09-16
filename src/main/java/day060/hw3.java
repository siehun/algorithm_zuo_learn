package day060;

import java.util.ArrayList;

public class hw3 {
    public int minimumTime(int n, int[][] relations, int[] time) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] degree = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] cur : relations) {
            graph.get(cur[0]).add(cur[1]);
            degree[cur[1]]++;
        }
        int[] que = new int[n];
        int[] cost = new int[n + 1];
        int l = 0, r = 0;
        for (int i = 1; i <= n; i++) {
            if (degree[i] == 0) {
                que[r++] = i;
            }
        }
        while (l < r) {
            int cur = que[l++];
            cost[cur] = cost[cur] + time[cur - 1];
            for (int next: graph.get(cur)) {
                cost[next] = Math.max(cost[next], cost[cur]);
                if (--degree[next] == 0) {
                    que[r++] = next;
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, cost[i]);
        }
        return ans;
    }
}
