package day059;

import java.util.ArrayList;

public class hw2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] degree = new int[numCourses];
        for (int[] cous : prerequisites) {
            int first = cous[1];
            int last = cous[0];
            graph.get(first).add(last);
            degree[last]++;
        }
        int[] que = new int[numCourses];
        int l = 0, r = 0;
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                que[r++] = i;
            }
        }
        int cnt = 0;
        while(l < r) {
            int cur = que[l++];
            cnt++;
            for (int node : graph.get(cur)) {
                if (--degree[node] == 0) {
                    que[r++] = node;
                }
            }
        }
        return cnt == numCourses ? que : new int[0];
    }
}
