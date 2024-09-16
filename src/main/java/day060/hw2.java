package day060;

import java.util.ArrayList;

public class hw2 {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int len = quiet.length;
        int[] degree = new int[len];
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = i;
        }
        for (int i = 0; i < len; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] cur : richer) {
            degree[cur[1]]++;
            graph.get(cur[0]).add(cur[1]);
        }
        int[] que = new int[len];
        int l = 0, r = 0;
        for (int i = 0; i < len; i++) {
            if (degree[i] == 0) {
                que[r++] = i;
            }
        }
        while(l < r) {
            int cur = que[l++];
            for (int i : graph.get(cur)) {
                ans[i] = quiet[ans[cur]] < quiet[ans[i]] ? ans[cur] : ans[i];
                if (--degree[i] == 0) {
                    que[r++] = i;
                }
            }
        }
        return ans;
    }
}
