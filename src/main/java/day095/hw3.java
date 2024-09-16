package day095;

import java.io.*;
public class hw3 {
    // 尼姆博弈
    // 一堆数异或起来为0，先手输
    // 最后拿空的时候异或起来为0
    // 数字总和在整体减少
    //异或起来为0，减少再次异或一定不为0
    //异或起来不为0，一定可以减少再次异或为0
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken();
        int t = (int) in.nval;
        for (int i = 0; i < t; i++) {
            in.nextToken();
            int n = (int) in.nval;
            int eor = 0;
            for (int j = 0; j < n; j++) {
                in.nextToken();
                eor ^= (int) in.nval;
            }
            if (eor != 0) {
                out.println("Yes");
            } else {
                out.println("No");
            }
        }
        out.flush();
        out.close();
        br.close();

    }
}
