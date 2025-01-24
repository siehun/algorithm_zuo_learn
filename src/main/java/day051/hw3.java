package day051;

import java.io.*;

// 机器人跳跃问题
// 机器人正在玩一个古老的基于DOS的游戏
// 游戏中有N+1座建筑，从0到N编号，从左到右排列
// 编号为0的建筑高度为0个单位，编号为i的建筑的高度为H(i)个单位
// 起初机器人在编号为0的建筑处
// 每一步，它跳到下一个（右边）建筑。假设机器人在第k个建筑，且它现在的能量值是E
// 下一步它将跳到第个k+1建筑
// 它将会得到或者失去正比于与H(k+1)与E之差的能量
// 如果 H(k+1) > E 那么机器人就失去H(k+1)-E的能量值，否则它将得到E-H(k+1)的能量值
// 游戏目标是到达第个N建筑，在这个过程中，能量值不能为负数个单位
// 现在的问题是机器人以多少能量值开始游戏，才可以保证成功完成游戏
// 测试链接 : https://www.nowcoder.com/practice/7037a3d57bbd4336856b8e16a9cafd71
// 请同学们务必参考如下代码中关于输入、输出的处理
// 这是输入输出处理效率很高的写法
// 提交以下的code，提交时请把类名改成"Main"，可以直接通过
public class hw3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            int n = (int)in.nval;
            int[] part = new int[n];
            int max = 0;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                part[i] = (int)in.nval;
                max= Math.max(max, part[i]);
            }
            int l = 1;
            int r = max;
            int ans = 0;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (f(part, mid, max)) {
                    ans = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            System.out.println(ans);
        }
        out.flush();
        out.close();
        br.close();
    }
    public static boolean f(int[] part, int mid, int r) {
        int cur = mid;
        for (int i = 0; i < part.length; i++) {
            if (part[i] < cur) {
                cur += (cur - part[i]);
            } else {
                cur -= (part[i] - cur);
            }
            if (cur < 0) {
                return false;
            }
            if (cur >= r) {
                return true;
            }
        }
        return true;
    }

}
