package day096;

import java.io.*;
import java.util.Arrays;

public class hw6 {
    public static int MAXN = 21;
    public static int[] nums = new int[MAXN];
    public static int[] sg = new int[MAXN];
    public static int MAXV = 101;
    public static boolean[] appear = new boolean[MAXV];
    public static int t, n;
    public static void build() {
        for (int i = 1; i < MAXN; i++) {
            Arrays.fill(appear, false);
            for (int j = i - 1; j >= 0; j--) {
                for (int k = j; k >= 0; k--) {
                    appear[sg[j] ^ sg[k]] = true;
                }
            }
            for (int s = 0; s < MAXV; s++) {
                if (!appear[s]) {
                    sg[i] = s;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        build();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken();
        t = (int) in.nval;
        for (int i = 0; i < t; i++) {
            in.nextToken();
            n = (int)in.nval;
            for (int j = n - 1; j >= 0; j--) {
                in.nextToken();
                nums[j] = (int) in.nval;
            }
            out.println(compute());
        }
        out.flush();
        out.close();
        br.close();
    }
    public static String compute() {
        int eor = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] % 2 == 1) {
                eor ^= sg[i];
            }
        }
        if (eor == 0) {
            return "-1 -1 -1\n" + "0";
        }
        int cnt = 0, a = -1, b = -1, c = -1,  pos;
        for (int i = n - 1; i >= 1; i--) {
            if (nums[i] > 0) {
                for (int j = i - 1; j >= 0; j--) {
                    for (int k = j; k >= 0; k--) {
                        pos = eor ^ sg[i] ^ sg[k] ^ sg[j];
                        if (pos == 0) {
                            cnt++;
                            if (a == -1) {
                                a = i;
                                b = j;
                                c = k;
                            }
                        }
                    }
                }
            }
        }
        return String.valueOf((n - 1 - a) + " " + (n - 1 - b)+ " " + (n - 1 - c) + "\n" + cnt);
    }
}
