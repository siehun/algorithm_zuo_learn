package day046;

import java.util.HashMap;

// 使数组和能被P整除
// 给你一个正整数数组 nums，请你移除 最短 子数组（可以为 空）
// 使得剩余元素的 和 能被 p 整除。 不允许 将整个数组都移除。
// 请你返回你需要移除的最短子数组的长度，如果无法满足题目要求，返回 -1 。
// 子数组 定义为原数组中连续的一组元素。
// 测试链接 : https://leetcode.cn/problems/make-sum-divisible-by-p/
public class hw6 {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int modd = 0;
        for (int i = 0; i < n; i++) {
            modd = (modd + nums[i]) % p;
        }
        if (modd == 0) {
            return 0;
        }
        for (int i = 0, mod = 0; i < n; i++) {
            mod = (mod + nums[i]) % p;
            int find = mod >= modd ? (mod - modd) : (mod + p - modd);
            if (map.containsKey(find)) {
                ans = Math.min(ans, i - map.get(find));
            }
            map.put(mod, i);
        }
        return ans == n ? -1 : ans;
    }
}
