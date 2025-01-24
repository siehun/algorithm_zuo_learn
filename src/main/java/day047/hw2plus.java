package day047;

import java.io.*;

public class hw2plus {
    public static int MAXN = 10000005;
    public static int n, m;
    public static long[] arr = new long[MAXN];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int) in.nval;
            in.nextToken();
            m = (int) in.nval;
            for (int i = 0; i < m; i++) {
                in.nextToken();
                int l = (int) in.nval;
                in.nextToken();
                int r = (int) in.nval;
                in.nextToken();
                long s = (long) in.nval;
                in.nextToken();
                long e = (long) in.nval;
                set(l, r, s, e, (e - s)/ (r - l));
            }
            build();
            long max = 0, xor = 0;
            for (int i = 1; i <= n; i++) {
                max = Math.max(max, arr[i]);
                xor ^= arr[i];
            }
            out.println(xor + " " + max);
        }
        out.flush();
        out.close();
        br.close();
    }
    public static void set(int l, int r, long s, long e, long d) {
        arr[l] += s;
        arr[l + 1] += d - s;
        arr[r + 1] -= e + d;
        arr[r + 2] += e;
    }
    public static void build() {
        for (int i = 1; i <= n; i++) {
            arr[i] += arr[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            arr[i] += arr[i - 1];
        }
    }
}
