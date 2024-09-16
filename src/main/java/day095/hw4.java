package day095;

import java.io.*;
public class hw4 {
    public static int MAXN = 51;
    public static int[] stones = new int[MAXN];
    public static int size;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken();
        int n = (int)in.nval;
        for (int i = 0; i < n; i++) {
            in.nextToken();
            size = (int)in.nval;
            for (int j = 0; j < size; j++) {
                in.nextToken();
                stones[j] = (int) in.nval;
            }
            out.println(compute());
        }
        out.flush();
        out.close();
        br.close();
    }
    public static String compute() {
        int eor = 0, sum = 0;
        for (int i = 0; i < size; i++) {
            eor ^= stones[i];
            sum += stones[i] == 1 ? 1 : 0;
        }
        // 石子一开始的数量不为0
        if (sum == size) {
            return (size & 1)  == 1 ? "Brother" : "John";
        } else {
            return eor != 0 ? "John" : "Brother";
        }
    }
}
