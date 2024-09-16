package day061;

import java.util.Arrays;
import java.util.Scanner;

public class hw6 {
    public static int MAXN = 8000;
    public static int[] father = new int[MAXN];
    public static void build(int n) {
        for (int i = 1; i <= n; i++) {
            father[i] = i;
        }
    }
    public static int find(int i) {
        if(i != father[i]) {
            father[i] = find(father[i]);
        }
        return father[i];
    }
    public static void union(int i, int j) {
        father[find(i)] = find(j);
    }
    public static boolean isSameSet(int i, int j) {
        return find(i) == find(j);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        build(n);
        int[][] record = new int[m][3];
        for (int i = 0; i < m; i++) {
            record[i][0] = sc.nextInt();
            record[i][1] = sc.nextInt();
            record[i][2] = sc.nextInt();
        }
        int size = 0;
        int max = 0;
        Arrays.sort(record, (a,b) -> a[2] - b[2]);
        for (int i = 0; i < record.length; i++) {
            int u = record[i][0];
            int v = record[i][1];
            int w = record[i][2];
            if (!isSameSet(u, v)) {
                max = Math.max(max, w);
                size++;
                union(u, v);
            }
        }
        System.out.println(size + " " + max);

    }
}
