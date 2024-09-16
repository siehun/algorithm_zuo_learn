package day059;

import java.util.ArrayList;
import java.util.Arrays;

public class hw1 {
    public static int MAXN_Point = 11;
    public static int MAXN_Edge = 21;
    // 邻接矩阵建图
    public static int[][] matrix = new int[MAXN_Point][MAXN_Point];

    // 邻接表建图

    public static ArrayList<ArrayList<int[]>> graph2 = new ArrayList<>();


    // 链式前向星
    // head[]数组，下标表示点的编号，值表示边的编号
    public static int[] head = new int[MAXN_Point];
    // next[]数组，下标表示边的编号，值表示下一条边的编号
    public static int[] next = new int[MAXN_Edge];
    //to[]数组，下标表示边的编号，值表示边指向的点
    public static int[] to = new int[MAXN_Edge];
    // 表示边的权值
    public static int[] weight = new int[MAXN_Edge];
    public static int cnt;

    public static void build(int n) {
        // 清理matrix
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                matrix[i][j] = 0;
            }
        }

        // 邻接表清空
        graph2.clear();
        for (int i = 0; i <= n; i++) {
            graph2.add(new ArrayList<>());
        }

        // 链式前向星清空
        cnt = 1;
        Arrays.fill(head, 1, n + 1, 0);

    }
    public static void traversal(int n) {
        System.out.println("邻接矩阵遍历");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("邻接表遍历");
        for (int i = 1; i <= n; i++) {
            System.out.println(i + "(邻居， 边权):");
            for (int[] edge : graph2.get(i)) {
                System.out.print("(" + edge[0] + "," + edge[1] + ")");
            }
            System.out.println();
        }
        System.out.println("链式前向星");
        for (int i = 1; i <= n; i++) {
            System.out.println(i + "(邻居，边权):");
            for (int ei = head[i]; ei > 0; ei = next[ei]) {
                System.out.print("(" + to[ei]+","+weight[ei] + ")");
            }
            System.out.println();
        }
    }
    public static void addEdge(int u, int v, int w) {
        to[cnt] = v;
        next[cnt] = head[u];
        head[u] = cnt;
        weight[cnt++] = w;
    }
    public static void directGraph(int[][] edges) {
        for (int[] edge : edges) {
            matrix[edge[0]][edge[1]] = edge[2];
        }
        for (int[] edge: edges) {
            graph2.get(edge[0]).add(new int[] {edge[1], edge[2]});
        }
        for (int[] edge : edges) {
            addEdge(edge[0], edge[1], edge[2]);
        }
    }public static void undirectGraph(int[][] edges) {
        for (int[] edge : edges) {
            matrix[edge[0]][edge[1]] = edge[2];
            matrix[edge[1]][edge[0]] = edge[2];
        }
        for (int[] edge: edges) {
            graph2.get(edge[0]).add(new int[] {edge[1], edge[2]});
            graph2.get(edge[1]).add(new int[] {edge[0], edge[2]});
        }
        for (int[] edge : edges) {
            addEdge(edge[0], edge[1], edge[2]);
            addEdge(edge[1], edge[0], edge[2]);
        }
    }
    public static void main(String[] args) {
        int n1 = 4;
        int[][] edges1 = {{1, 3, 6}, {4, 3, 4},{2, 4, 2},{1,2,7},{2, 3, 5}, {3, 1, 1}};
        build(n1);
        directGraph(edges1);
        traversal(n1);
        System.out.println("==============");
        int n2 = 5;
        int[][] edges2 = {{3, 5, 4},{4, 1, 1}, {3, 4, 2}, {5, 2, 4},{2, 3, 7},{1, 5, 5},{4, 2, 6}};
        build(n2);
        undirectGraph(edges2);
        traversal(n2);
    }
}
