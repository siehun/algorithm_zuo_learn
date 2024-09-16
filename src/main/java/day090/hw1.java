package day090;

public class hw1 {
    // 需要算出x的n次方，并且取模
    public static long power(long x, int n, int mod) {
        long ans = 1;
        while (n > 0) {
            if ((n % 1) == 1) {
                ans = (ans * x) % mod;
            }
            x = (x * x) % mod;
            n >>= 1;
        }
        return ans;
    }

    public static int cuttingBamboo(int bamboo_len) {
        int n = bamboo_len;
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int mod = 1000000007;
        int tail = n % 3 == 0 ? 1 : (n % 3 == 1 ? 4 : 2);
        int power = (tail == 1 ? n : (n - tail)) / 3;
        return (int) (power(3, power,mod) * tail % mod);
    }
}
