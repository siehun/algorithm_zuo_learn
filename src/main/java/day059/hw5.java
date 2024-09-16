package day059;

import java.util.PriorityQueue;
import java.util.Scanner;

public class hw5 {
    public static int MAXN = 100001;
    public static int[] head = new int[MAXN];
    public static int[] next = new int[MAXN];
    public static int[] to = new int[MAXN];
    public static int cnt = 1;
    public static void addEdge(int u, int v) {
        next[cnt] = head[u];
        head[u] = cnt;
        to[cnt++] = v;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] degree = new int[n + 1];
        int[] ans = new int[n + 1];
        int index = 0;
        for (int i = 0; i < m; i++) {
            int first = sc.nextInt();
            int last = sc.nextInt();
            addEdge(first, last);
            degree[last]++;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 1; i < degree.length; i++) {
            if (degree[i] == 0) {
                heap.add(i);
            }
        }
        while (!heap.isEmpty()) {
            int cur = heap.poll();
            ans[index++] = cur;
            for (int ei = head[cur]; ei > 0; ei = next[ei]) {
                if (--degree[to[ei]] == 0) {
                    heap.add(to[ei]);
                }
            }
        }
        for (int i = 0; i < index; i++) {
            if (i == index - 1) {
                System.out.println(ans[i]);
            } else {
                System.out.print(ans[i] +" ");
            }
        }

    }
}
