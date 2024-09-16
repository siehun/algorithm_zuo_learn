package day059;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class hw3 {
    public static int MAXN = 1000001;
    public static int[] ans = new int[MAXN];
    public static int n, m;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] degree = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int first = sc.nextInt();
            int last = sc.nextInt();
            graph.get(first).add(last);
            degree[last]++;
        }
        int[] que = new int[n + 1];
        int l = 0, r = 0;
        for (int i = 1; i < degree.length; i++) {
            if (degree[i] == 0) {
                que[r++] = i;
            }
        }
        int cnt = 0;
        while (l < r) {
            int cur = que[l++];
            cnt++;
            for (int i : graph.get(cur)) {
                if (--degree[i] == 0) {
                    que[r++] = i;
                }
            }
        }
        if (cnt != n) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < n; i++) {
                if (i == n - 1) {
                    System.out.print(que[i]);
                } else {
                    System.out.print(que[i] + " ");
                }
            }
        }


    }
}
