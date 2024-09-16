package day095;

public class hw1 {
    // 巴什博弈
    // 谁拿到最后一个谁赢
    // 一共有 n个石子, 一次可以拿m个
    public static void main(String[] args) {
        int V = 500;
        int testTimes = 5000;
        System.out.println("测试开始");
        for (int i = 0; i < testTimes; i++) {
            int n = (int) (Math.random() * V);
            int m = (int) (Math.random() * V) + 1;
            String ans1 = bathGame1(n, m);
            String ans2 = bathGame2(n, m);
            if (!ans1.equals(ans2)) {
                System.out.println("出错了");
            }
        }
        System.out.println("测试结束");
    }
    public static String bathGame2(int n, int m) {
        return n % (m + 1) != 0 ? "先手" : "后手";
    }
    public static int MAXN = 1001;
    public static String[][] dp = new String[MAXN][MAXN];
    public static String bathGame1(int n, int m) {
        if (n == 0) {
            return "后手";
        }
        if (dp[n][m] != null) {
            return dp[n][m];
        }
        // 假设输了
        String ans = "后手";
        // 从1到m，看有没有可能赢
        for (int pick = 1; pick <= m; pick++) {
            // 这里有个很有意思的点n - pick不会出现负数，
            //  n - pick只要到0，一定会出现后手然后终止
            if (bathGame1(n - pick, m).equals("后手")) {
                ans = "先手";
                break;
            }
        }
        dp[n][m] = ans;
        return ans;

    }
}
