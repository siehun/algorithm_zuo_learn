package day052;

import java.util.Scanner;

public class hw1 {
    public static int MAXN = 1000008;
    public static int[] stack = new int[MAXN];
    public static int l = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int[][] min = new int[N][2];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            while (l > 0 && arr[i] <= arr[stack[l - 1]]) {
                int cur = stack[--l];
                min[cur][1] = i;
                min[cur][0] = l == 0 ? -1 : stack[l -  1];
            }
                stack[l++] = i;
        }
        while (l > 0) {
            int cur = stack[--l];
            min[cur][1] = -1;
            min[cur][0] = l == 0 ? -1 : stack[l - 1];
        }

        for (int i = N - 2; i >= 0; i--) {
            if (min[i][1] != -1 && arr[min[i][1]] == arr[i]) {
                min[i][1] = min[min[i][1]][1];
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println(min[i][0] +" " +min[i][1]);
        }
    }
}
