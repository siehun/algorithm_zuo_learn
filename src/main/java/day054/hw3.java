package day054;

import java.io.*;
import java.util.*;

public class hw3 {
    public static int MAXN = 100005;
    // 每滴水的坐标
    public static int[][] arr = new int[MAXN][2];
    // n滴水，限制为d
    public static int n, d;
    //单调队列维护最大值
    public static int[] maxDeque = new int[MAXN];
    //单调队列维护最小值
    public static int[] minDeque = new int[MAXN];
    //头尾指针，左闭右开
    public static int maxh, maxt, minh, mint;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int) in.nval;
            in.nextToken();
            d = (int) in.nval;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                arr[i][0] = (int) in.nval;
                in.nextToken();
                arr[i][1] = (int) in.nval;
            }
            int ans = compute();
            out.println(ans == Integer.MAX_VALUE ? -1 : ans);
        }
        out.flush();
        out.close();
        br.close();
    }
    public static int compute() {
        Arrays.sort(arr, 0, n, (a, b) -> a[0] - b[0]);
        maxh = maxt = minh = mint = 0;
        int ans = Integer.MAX_VALUE;
        for (int l = 0, r = 0; l < n; l++) {
            while (r < n && !ok()) {
                push(r++);
            }
            if (ok()) {
                ans = Math.min(ans, arr[r-1][0] - arr[l][0]);
            }
            pop(l);
        }
        return ans;
    }
    public static boolean ok() {
        int min = minh < mint ? arr[minDeque[minh]][1] : 0;
        int max = maxh < maxt ? arr[maxDeque[maxh]][1] : 0;
        return max - min >= d;
    }
    public static void push(int i) {
        while (minh < mint && arr[i][1] <= arr[minDeque[mint-1]][1]) {
            mint--;
        }
        minDeque[mint++] = i;
        while (maxh < maxt && arr[i][1] >= arr[maxDeque[maxt-1]][1]) {
            maxt--;
        }
        maxDeque[maxt++] = i;
    }
    public static void pop(int l) {
        if (minh < mint && minDeque[minh] == l) {
            minh++;
        }
        if (maxh < maxt && maxDeque[maxh] == l) {
            maxh++;
        }
    }

}
