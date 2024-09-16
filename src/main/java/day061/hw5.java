package day061;

import java.util.Arrays;

public class hw5 {
    public static int MAXN = 100001;
    public static int[][] question = new int[MAXN][4];
    public static int[] father = new int[MAXN];
    public static void build(int n) {
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }
    public static int find(int i) {
        if (i != father[i]) {
            father[i] = find(father[i]);
        }
        return father[i];
    }
    public static void union(int i, int j) {
        father[find(i)] = find(j);
    }
    public static boolean isSameSet(int u, int v) {
        return find(u) == find(v);
    }
    public static boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        int len = queries.length;
        int len2 = edgeList.length;
        for (int i = 0; i < len; i++) {
            question[i][0] = queries[i][0];
            question[i][1] = queries[i][1];
            question[i][2] = queries[i][2];
            question[i][3] =  i;
        }
        Arrays.sort(question,0,len, (a, b) -> a[2] - b[2]);
        build(n);
        boolean[] ans = new boolean[len];
        for (int i = 0, j = 0; i < len; i++) {
            int u = question[i][0];
            int v = question[i][1];
            int limit = question[i][2];
            for (;j < len2 && edgeList[j][2] < limit; j++) {
                 union(edgeList[j][0], edgeList[j][1]);
            }
            ans[question[i][3]] = isSameSet(u, v);

        }
        return ans;
    }

}
