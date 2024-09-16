package day064;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class hw1 {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] record = new int[n + 1];
        Arrays.fill(record, Integer.MAX_VALUE);
        for (int[] cur : times) {
            graph.get(cur[0]).add(new int[]{cur[1], cur[2]});
        }
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        heap.add(new int[]{k, 0});
        record[k] = 0;
        while(!heap.isEmpty()) {
            int u = heap.poll()[0];
            if (visited[u]) {
                continue;
            }
            visited[u] = true;
            for (int[] cur : graph.get(u)) {
                int v = cur[0];
                int w = cur[1];
                if (!visited[v] && record[u] + w < record[v]) {
                    record[v] = record[u] + w;
                    heap.add(new int[]{v, record[v]});
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i<= n; i++) {
            if (record[i] == Integer.MAX_VALUE) {
                return -1;
            }
            ans = Math.max(ans, record[i]);
        }
        return ans;


    }
}
