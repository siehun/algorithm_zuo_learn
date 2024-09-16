package day069;

public class hw1 {
    public static int zero, one;
    public static void count(String str) {
        char[] arr = str.toCharArray();
        int len = arr.length;
        zero = 0;
        one = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] == '0') {
                zero++;
            } else {
                one++;
            }
        }
    }
    public static int f(String[] strs, int i, int m, int n) {
        if (i == strs.length) {
            return 0;
        }
        int p2 = 0;
        int p1 = f(strs, i + 1, m, n);
        count(strs[i]);
        if (zero <= m && one <= n) {
            p2 = f(strs,i + 1, m - zero, n - one) + 1;
        }
        return Math.max(p1, p2);

    }
    public static int f1(String[] strs, int i, int m, int n, int[][][] dp) {
        return 0;

    }
    public static int findMaxForm(String[] strs, int m,int n) {
        return 0;

    }
    public static int findMaxForm1(String[] strs, int m, int n) {

        return f(strs, 0, m, n);

    }
    public static void main(String[] args) {
        String[] str = {"10","0","1"};
        int m = 1;
        int n = 1;
        int ans = findMaxForm(str, m, n);
        System.out.println(ans);
    }
}
