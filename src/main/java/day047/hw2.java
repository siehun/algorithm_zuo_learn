package day047;

import java.io.BufferedInputStream;
import java.util.Scanner;

// 一开始1~n范围上的数字都是0，一共有m个操作，每次操作为(l,r,s,e,d)
// 表示在l~r范围上依次加上首项为s、末项为e、公差为d的数列
// m个操作做完之后，统计1~n范围上所有数字的最大值和异或和
// 测试链接 : https://www.luogu.com.cn/problem/P4231
public class hw2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int N = sc.nextInt();
        int M = sc.nextInt();
        long[] arr = new long[N + 3];
        for (int i = 0; i < M; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int s = sc.nextInt();
            int e = sc.nextInt();
            int d = (e - s) / (r - l);
            arr[l] += s;
            arr[l + 1] += d - s;
            arr[r + 1] -= e + d;
            arr[r + 2] += e;
        }
        for (int i = 1; i < N + 3; i++) {
            arr[i] = arr[i - 1] + arr[i];
        }
        for (int i = 1; i < N + 3; i++) {
            arr[i] = arr[i - 1] + arr[i];
        }
        long max = 0;
        long esum = 0;
        for (int i = 1; i < N + 1; i++) {
            max = Math.max(arr[i], max);
            esum ^= arr[i];
        }
        System.out.println(esum + " " + max);
    }
}
