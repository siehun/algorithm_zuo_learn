package day095;

import java.io.*;
import java.util.*;
public class hw5 {
    public static long MAXN = 1000000000000000L;
    public static int MAXM = 101;
    public static long[] f = new long[MAXM];
    public static int size;
    public static void build() {
        f[0] = 1;
        f[1] = 2;
        size = 1;
        while (f[size] <= MAXN) {
            f[size + 1] = f[size] + f[size - 1];
            size++;
        }
    }
    public static void main(String[] args) throws IOException{
        build();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            out.println(compute((long) in.nval));
        }
        out.flush();
        out.close();
        br.close();
    }
    public static long bs(long n) {
        int l = 0;
        int r = size;
        long ans = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (f[m] <= n) {
                ans = f[m];
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }
    public static long compute(long n) {
        long ans = -1;
        while (n != -1 && n != -2) {
            long find = bs(n);
            if (n == find) {
                ans = find;
                break;
            } else {
                n -= find;
            }
        }
        if (ans != -1) {
            return ans;
        } else {
            return n;
        }
    }
}
