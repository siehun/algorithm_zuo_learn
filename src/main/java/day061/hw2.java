package day061;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class hw2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        boolean[] visited = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph.get(u).add(new int[] {v,w});
            graph.get(v).add(new int[] {u, w});
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        for (int[] cur : graph.get(1)) {
            heap.add(cur);
        }
        int cnt = 1;
        int ans = 0;
        visited[1] = true;
        while(!heap.isEmpty()) {
            int[] cur = heap.poll();
            if (!visited[cur[0]]) {
                cnt++;
                visited[cur[0]] = true;
                ans += cur[1];
                for (int[] next : graph.get(cur[0])) {
                    heap.add(next);
                }
            }
        }
        if (cnt == n) {
            System.out.println(ans);
        } else {
            System.out.println("orz");
        }

    }
}
