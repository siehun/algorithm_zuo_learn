package day052;

public class hw3 {
    public static int mod = 1000000007;
    public static int MAXN = 30000;
    public static int[] stack = new int[MAXN];
    public static int l = 0;
    // hello what is your rname ?

    public int sumSubarrayMins(int[] arr) {
        long ans = 0;
        int N = arr.length;
        for (int i = 0; i < arr.length; i++) {
            while (l > 0 && arr[i] <= arr[stack[l - 1]]) {
                int cur = stack[--l];
                int left = l == 0 ? -1 : stack[l - 1];
                // 注意这里， 丫的，三数相乘可能就超出int范围了
                ans = (ans + (long) (cur - left) * (i - cur) * arr[cur]) % mod;
            }
            stack[l++] = i;
        }
        while (l != 0) {
            int cur = stack[--l];
            int left = l == 0 ? -1: stack[l - 1];
            ans = (ans + (long) (cur - left) * (N - cur) * arr[cur]) % mod;
        }
        return (int) ans;

    }
}
