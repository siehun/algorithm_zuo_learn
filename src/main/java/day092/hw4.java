package day092;

import java.io.*;
import java.util.Arrays;

public class hw4 {
    public static int MAXN = 200001;
    public static int[][] nums = new int[MAXN][2];
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken();
        n = (int)in.nval;
        for (int i = 0; i < n; i++) {
            in.nextToken();
            nums[i][0] = (int)in.nval;
            in.nextToken();
            nums[i][1] = (int)in.nval;
        }
        int ans = compute();
        out.println((double) ans/ 2);
        out.flush();
        out.close();
        br.close();
    }
    public static int compute() {
        Arrays.sort(nums, 0, n,(a, b)-> Math.abs(a[0] - a[1])- Math.abs(b[0] - b[1]));
        int maxx = nums[0][0];
        int maxy = nums[0][1];
        int ans = 0;
        for (int i = 1; i < n; i++) {
            int curx = nums[i][0];
            int cury = nums[i][1];
            if (curx < cury) {
                ans = Math.max(curx + maxx,ans);
            } else {
                ans = Math.max(cury + maxy, ans);
            }
            maxx = Math.max(curx, maxx);
            maxy = Math.max(cury, maxy);
        }
        return ans;
    }
}
