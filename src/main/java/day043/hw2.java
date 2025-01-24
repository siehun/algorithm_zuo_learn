package day043;
// 超级回文数(java版)
// 如果一个正整数自身是回文数，而且它也是一个回文数的平方，那么我们称这个数为超级回文数。
// 现在，给定两个正整数 L 和 R （以字符串形式表示），
// 返回包含在范围 [L, R] 中的超级回文数的数目。
// 1 <= len(L) <= 18
// 1 <= len(R) <= 18
// L 和 R 是表示 [1, 10^18) 范围的整数的字符串
//测试链接 : https://leetcode.cn/problems/super-palindromes/
public class hw2 {
    public int superpalindromesInRange(String left, String right) {
        // l - r
        long l = Long.valueOf(left);
        long r = Long.valueOf(right);
        // 根号x
        long limit = (long) Math.sqrt((double) r);
        // 种子
        long seed = 1;
        long num = 0;
        int ans = 0;
        do {
            num = evenEnlarge(seed);
            if (check(num * num, l, r)) {
                ans++;
            }
            num = oddEnlarge(seed);
            if (check(num * num, l, r)) {
                ans++;
            }
            seed++;
        } while (num < limit);
        return ans;
    }
    public long evenEnlarge(long seed) {
        // 123   123 321
        long ans = seed;
        while (seed != 0) {
            ans = ans * 10 + seed % 10;
            seed /= 10;
        }
        return ans;
    }

    public long oddEnlarge(long seed) {
        //123 12321
        long ans = seed;
        seed /= 10;
        while (seed != 0) {
            ans = ans * 10 + seed % 10;
            seed /= 10;
        }
        return ans;
    }
    public boolean check(long num , long l, long r) {
        return num >= l && num <= r && isPalindrome(num);
    }
    // 验证long类型的数字num，是不是回文数字
    public static boolean isPalindrome(long num) {
        long offset = 1;
        // 注意这么写是为了防止溢出
        while (num / offset >= 10) {
            offset *= 10;
        }
        // num    : 52725
        // offset : 10000
        // 首尾判断
        while (num != 0) {
            if (num / offset != num % 10) {
                return false;
            }
            num = (num % offset) / 10;
            offset /= 100;
        }
        return true;
    }
}
