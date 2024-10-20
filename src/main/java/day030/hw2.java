package day030;
// 返回两个数中最大的那个数
public class hw2 {
    // 必须保证n一定时0或者1
    public static int flip(int n) {
        return n ^ 1;
    }
    // >= 0  1
    // < 0   0
    public static int sign(int n) {
        return flip(n >>> 31);
    }
    // 有溢出风险
    public static int getMax1(int a, int b) {
        int c = a - b;
        // 下面这两互斥，对a, b进行01选择
        int retA = sign(c);
        int retB = flip(retA);
        return a * retA + b * retB;
    }

    //
    public static int getMax2(int a, int b) {
        // c可能时溢出的
        int c = a - b;
        // 判断三个的符号
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);
        //判断a和b符号异同, 不同为1， 相同为0
        int diffAB = sa ^ sb;
        int sameAB = flip(diffAB);

        // 列举返回a的情况，符号不同，a为正,符号相同, c为正
        int retA = diffAB * sa + sameAB * sc;
        int retB = flip(retA);

        // 该返回a返回a, 该返回b返回b
        return a * retA + b * retB;
    }


}
