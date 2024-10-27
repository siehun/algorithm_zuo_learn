package day042;
// 有装下8个苹果的袋子、装下6个苹果的袋子，一定要保证买苹果时所有使用的袋子都装满
// 对于无法装满所有袋子的方案不予考虑，给定n个苹果，返回至少要多少个袋子
// 如果不存在每个袋子都装满的方案返回-1
public class hw1 {

    public static void main(String[] args) {
        // 苹果最大数量
        int n = 200;
        for (int i = 1; i <= 200; i++) {
            int ans = f2(i);
            System.out.println(i + "个苹果:"+ (ans == Integer.MAX_VALUE ? -1 : ans));
        }
    }
    public static int f(int apple) {
        if (apple == 0) {
            return 0;
        }
        if (apple < 0) {
            return Integer.MAX_VALUE;
        }
        int applesix = f(apple - 6);
        int appleeig = f(apple - 8);
        if (applesix != Integer.MAX_VALUE) {
            applesix++;
        }
        if (appleeig != Integer.MAX_VALUE) {
            appleeig++;
        }
        return Math.min(applesix, appleeig);
    }
    public static int f2(int apple) {
        if (apple < 18) {
            if (apple == 6 || apple == 8) {
                return 1;
            }
            if (apple == 12 || apple == 14 || apple  == 16) {
                return 2;
            }
            return -1;
        }
        if ((apple & 1) == 1) {
            return -1;
        }
        return (apple - 18) / 8 + 3;
    }
}
