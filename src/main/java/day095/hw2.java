package day095;

import java.io.*;

public class hw2 {
    // 巴什博弈的小拓展
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken();
        int t = (int) in.nval;
        for (int i = 0; i < t; i++) {
            in.nextToken();
            int n = (int) in.nval;
            out.println(compute(n));
        }
        out.flush();
        out.close();
        br.close();
    }
    // 6 及其倍数不能表示为质数的自然数次方
    public static String compute(int n) {
        return n % 6 != 0 ? "October wins!" : "Roy wins!" ;
    }
}
