package day073;

public class hw4 {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int midval = f(stones, sum / 2);
        return sum - 2 * midval;
    }
    // 划分两个阵营，
    public int f(int[] stones, int target) {
        // dp[i][j]表示选择从1到i个石头，重量最多为j,最大的重量可达到多少
       int n = stones.length;
       int[][] dp = new int[n+1][target + 1];
       for (int i = 1; i <= n; i++) {
           for (int j = target; j >= 0; j--) {
               dp[i][j] = dp[i - 1][j];
               if (j - stones[i - 1] >= 0) {
                   dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i-1]] + stones[i-1]);
               }
           }
       }
       return dp[n][target];
    }
}
