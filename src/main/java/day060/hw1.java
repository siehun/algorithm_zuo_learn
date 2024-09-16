package day060;

import java.util.ArrayList;
import java.util.Scanner;

public class hw1 {
    public static int mod = 80112002;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] degree = new int[n + 1];
        int[] ans = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int last = sc.nextInt();
            int first = sc.nextInt();
            graph.get(first).add(last);
            degree[last]++;
        }
        int[] que = new int[n + 1];
        int l = 0, r = 0;
        for (int i = 1; i <= n; i++) {
            if (degree[i] == 0) {
                que[r++] = i;
                ans[i] = 1;
            }
        }
        while (l < r) {
            int cur = que[l++];
            for (int i : graph.get(cur)) {
                ans[i] = (ans[i] + ans[cur]) % mod;
                if (--degree[i] == 0) {
                    que[r++] = i;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < graph.size(); i++) {
            if (graph.get(i).isEmpty()) {
                res = (res + ans[i]) % mod;
            }
        }
        System.out.println(res);
    }
}
