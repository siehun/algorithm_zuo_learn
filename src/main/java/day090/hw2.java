package day090;

public class hw2 {
    public static int f(int n, int k) {
        if (k == 1) {
            return n;
        }
        int ans = Integer.MIN_VALUE;
        for (int cur = 1; cur <= n && (n - cur) >= (k - 1); cur++) {
            int curAns = cur * f(n - cur, k -1);
            ans = Math.max(ans, curAns);
        }
        return ans;
    }
    public static long power(long x, int n, int mod) {
        long ans = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                ans = (ans * x ) % mod;
            }
            x = (x * x) % mod;
            n >>= 1;
        }
        return ans;
    }
    public static int maxValue2(int n, int k) {
        int mod = 1000000007;
        long a = n / k;
        int b = n % k;
        long part1 = power(a + 1, b, mod);
        long part2 = power(a , k - b, mod);
        return (int) (part1 * part2) % mod;
    }
}
