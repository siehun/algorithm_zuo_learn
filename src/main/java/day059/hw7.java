package day059;

import java.util.ArrayList;
import java.util.Arrays;

public class hw7 {
    public int[] movesToStamp(String stamp, String target) {
        char[] s = stamp.toCharArray();
        char[] t = target.toCharArray();
        int n = t.length;
        int m = s.length;
        int[] degree = new int[n - m + 1];
        Arrays.fill(degree, m);
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] queue = new int[n - m + 1];
        int l = 0, r = 0;
        for (int i = 0; i < n - m + 1; i++) {
            for (int j = 0; j < m; j++) {
                if (t[i + j] == s[j]) {
                    if (--degree[i] == 0) {
                        queue[r++] = i;
                    }
                } else {
                    graph.get(i + j).add(i);
                }
            }
        }
        boolean[] visited = new boolean[n];
        int[] path = new int[n - m + 1];
        int index = 0;
        while (l < r) {
            int cur = queue[l++];
            path[index++] = cur;
            for (int i = 0; i < m; i++) {
                if (!visited[cur + i]) {
                    visited[cur + i] = true;
                    for (int ii : graph.get(cur + i)) {
                        if (--degree[ii] == 0) {
                            queue[r++] = ii;
                        }
                    }
                }
            }
        }
        if (index != n - m + 1) {
            return new int[0];
        }
        for (int i = 0, j = index - 1; i < j; i++, j--) {
            int tmp = path[i];
            path[i] = path[j];
            path[j] = tmp;
        }
        return path;
    }
}
