package day047;

import java.io.*;

public class hw3 {
    public static int offset = 30003;
    public static int n, m;
    public static int MAXN = 1000000;
    public static int[] arr = new int[offset + MAXN + offset];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int)in.nval;
            in.nextToken();
            m = (int)in.nval;
            for (int i = 0; i < n; i++) {
                in.nextToken(); int v = (int)in.nval;
                in.nextToken(); int x = (int)in.nval;
                build(v, x);
            }
            f();
            for (int i = offset + 1; i <= offset + m; i++) {
                if (i == offset + m) {
                   out.println(arr[i]);
                } else {
                    out.print(arr[i] + " ");
                }
            }
        }
        out.flush();
        out.close();
        br.close();
    }
    public static void build(int v, int x) {
        set(x, x + 2 * v - 1, -v, v-1, 1);
        set(x + 2 * v, x + 3 * v, v, 0, -1);
        set(x - 2 * v, x - 1,  v, -v + 1, -1);
        set(x - 3 * v, x - 2 * v - 1, 0, v - 1, 1);
    }
    public static void set(int l, int r, int s, int e, int d) {
        arr[l + offset] += s;
        arr[l + offset + 1] += d -s;
        arr[r + offset + 1] -= e + d;
        arr[r + offset + 2] += e;
    }
    public static void f() {
        for (int i = 1; i <= offset + m; i++) {
            arr[i] += arr[i - 1];
        }
        for (int i = 1; i <= offset + m; i++) {
            arr[i] += arr[i - 1];
        }
    }
}
