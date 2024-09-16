package day061;

import java.util.Arrays;
import java.util.Scanner;

public class hw1 {
    public static int MAXN = 5000;
    public static int[] father = new int[MAXN];
    public static void build(int n) {
        for (int i = 1; i <= n; i++) {
            father[i] = i;
        }
    }
    public static int find(int i) {
        if (i != father[i]) {
            father[i] = find(father[i]);
        }
        return father[i];
    }

    public static boolean union(int i, int j) {
        int fx = find(i);
        int fy = find(j);
        if (fx != fy) {
            father[fx] = fy;
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] record = new int[m][3];
        for (int i = 0; i < m; i++) {
            record[i][0] = sc.nextInt();
            record[i][1] = sc.nextInt();
            record[i][2] = sc.nextInt();
        }
        build(n);
        Arrays.sort(record,(a,b) -> a[2] - b[2]);
        int cnt = 0;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            if (union(record[i][0],record[i][1])) {
                cnt++;
                ans += record[i][2];
            }
        }
        if (cnt == n - 1) {
            System.out.println(ans);
        } else {
            System.out.println("orz");
        }
    }
}
