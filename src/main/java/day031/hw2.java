package day031;
// 判断一个整数是不是3的幂
// 测试链接 : https://leetcode.cn/problems/power-of-three/
public class hw2 {
    public static boolean isPowerOfThree(int n) {
//        return n > 0 && 1162261467 % n == 0;
        return n > 0 && Math.pow(3, 19) % n == 0;
    }
}
