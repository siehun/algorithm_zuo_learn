package day061;

import java.util.ArrayList;
import java.util.Arrays;

public class hw4 {
    public int MAXN = 10001;
    public int[] father = new int[MAXN];
    public void build(int n) {
        for (int i = 0; i <= n; i++) {
            father[i] = i;
        }
    }
    public int find(int i) {
        if (i != father[i]) {
            father[i] = find(father[i]);
        }
        return father[i];
    }
    public boolean union(int i, int j) {
        int fx = find(i);
        int fy = find(j);
        if (fx != fy) {
            father[fx] = fy;
            return true;
        }
        return false;
    }
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        build(n);
        int len = pipes.length;
        int len2 = wells.length;
        int[][] help = new int[len + len2][3];
        int size = 0;
        for (int[] cur : pipes) {
            help[size][0] = cur[0];
            help[size][1] = cur[1];
            help[size++][2] = cur[2];
        }
        for (int i = 1; i <= len2; i++) {
            help[size][0] = 0;
            help[size][1] = i;
            help[size++][2] = wells[i - 1];
        }
        int ans = 0;
        Arrays.sort(help, (a, b) -> a[2] - b[2]);
        for (int i = 0; i < help.length; i++) {
            int u = help[i][0];
            int v = help[i][1];
            int w = help[i][2];
            if (union(u, v)) {
                ans += w;
            }
        }
        return ans;



    }
}
