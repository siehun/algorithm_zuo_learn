package day042;
// 可以用r、e、d三种字符拼接字符串，如果拼出来的字符串中
// 有且仅有1个长度>=2的回文子串，那么这个字符串定义为"好串"
// 返回长度为n的所有可能的字符串中，好串有多少个
// 结果对 1000000007 取模， 1 <= n <= 10^9
// 示例：
// n = 1, 输出0
// n = 2, 输出3
// n = 3, 输出18
public class hw4 {
    public static void main(String[] args) {
        // 数量从2到29
        for (int i = 2; i < 30; i++) {
            int ans = count(i);
            System.out.println(ans);
        }
    }
    public static int count(int num) {
        char[] path = new char[num];
        return f(path, 0);
    }
    public static int f(char[] path, int i) {
        if (i == path.length) {
            int n = path.length;
            int ans = 0;
            for (int l = 0; l < n - 1; l++) {
                for (int r = l + 1; r < n; r++) {
                    if (is(path, l, r)) {
                        ans++;
                    }
                }
            }
            return ans == 1  ? 1 : 0;
        } else {
            path[i] = 'r';
            int ans1 = f(path,i + 1);
            path[i] = 'e';
            int ans2 = f(path,i + 1);
            path[i] = 'd';
            int ans3 = f(path,i + 1);
            return ans1 + ans2 + ans3;
        }
    }
    // 检验是否为回文串
    public static boolean is(char[] s, int l, int r) {
        while (l < r) {
            if (s[l] != s[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    public static int num2(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 3;
        }
        if (n == 3) {
            return 18;
        }
        return (int) (((long) 6 * (n + 1)) % 1000000007);
    }
}
