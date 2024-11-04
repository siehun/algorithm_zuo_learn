package day041;
// 一个正整数如果能被 a 或 b 整除，那么它是神奇的。
// 给定三个整数 n , a , b ，返回第 n 个神奇的数字。
// 因为答案可能很大，所以返回答案 对 1000000007 取模
// 测试链接 : https://leetcode.cn/problems/nth-magical-number/
public class hw2 {

    long mod = (long)(Math.pow(10, 9) + 7);

    public long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    public long lcm(long a, long b) {
        return (long) a / gcd(a, b) * b;
    }
    public int nthMagicalNumber(int n, int a, int b) {
        long ans = 1;
        long lcm = lcm(a, b);
        long l = 1;
        long r = (long)n * Math.min(a, b);
        while (l <= r) {
            long mid = (l + r) / 2;
            if (mid / a + mid / b - mid / lcm >= n) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int) (ans % 1000000007);
    }
}
