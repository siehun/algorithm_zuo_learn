package day073;

import java.util.HashMap;

public class hw3 {
    // 暴力展开
    public int findTargetSumWays(int[] nums, int target) {
        return f(nums, target, 0, 0);
    }
    public int f(int[] nums, int target, int i, int sum) {
        if (i == nums.length) {
            return sum == target ? 1 : 0;
        }
        return f(nums, target, i + 1, sum + nums[i]) + f(nums, target, i + 1, sum - nums[i]);
    }
    // 记忆化搜索
    public int findTargetSumWays1(int[] nums, int target) {
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        return f1(nums, target, 0, 0, map);
    }
    public int f1(int[] nums, int target, int i, int sum, HashMap<Integer, HashMap<Integer, Integer>> map) {
        if (i == nums.length) {
            return sum == target ? 1: 0;
        }
        if (map.containsKey(i) && map.get(i).containsKey(sum)) {
            return map.get(i).get(sum);
        }
        int ans = f1(nums, target, i + 1, sum + nums[i],map) + f1(nums,target, i + 1, sum-nums[i],map);
        map.putIfAbsent(i, new HashMap<>());
        map.get(i).put(sum, ans);
        return ans;
    }
    // 平移技巧
    public int findTargetSumWays2(int[] nums, int target) {
        int s = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            s += nums[i];
        }
        if (target < -s || target > s) {
            return 0;
        }
        // 平移到(0, 2s)
        int m = 2 * s + 1;
        // dp[i][j]从0到i个数，结果为m的个数
        int[][] dp = new int[n + 1][m];
        dp[n][target + s] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = -s; j <= s; j++) {
                if (j + nums[i] + s < m) {
                    dp[i][j + s] = dp[i + 1][j + nums[i] + s];
                }
                if (j - nums[i] + s >= 0) {
                    dp[i][j + s] += dp[i + 1][j - nums[i] + s];
                }
            }
        }
        return dp[0][s];
    }
    public int findTargetSumWays3(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < target || -sum > target || ((target & 1) ^ (sum & 1))==1) {
            return 0;
        }
        return subsets(nums, (target + sum) >> 1);
    }
    public int subsets(int[] nums, int t) {
        if (t < 0) {
            return 0;
        }
        // 0代表没有,从第1个数到第i个数，结果为j的个数
        // dp[i][j]不要第i个数和要第i个数之和
        int[] dp = new int[t + 1];
        dp[0] = 1;
        int n = nums.length;
        for (int i = 1; i <= n; i++) {
            for (int j = t; j>= nums[i-1]; j--) {
                dp[j] += dp[j - nums[i-1]];
            }
        }
        return dp[t];
    }




}
