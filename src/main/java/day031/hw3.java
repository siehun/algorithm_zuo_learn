package day031;

// 已知n是非负数
// 返回大于等于n的最小的2某次方
// 如果int范围内不存在这样的数，返回整数最小值
public class hw3 {
    public static int near2power(int n) {
        if (n <= 0) {
            return 1;
        }
        n--;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n + 1;
    }
}
