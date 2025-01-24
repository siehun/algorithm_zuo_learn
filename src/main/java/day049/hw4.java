package day049;

// 加油站
// 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
// 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升
// 你从其中的一个加油站出发，开始时油箱为空。
// 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周
// 则返回出发时加油站的编号，否则返回 -1
// 如果存在解，则 保证 它是 唯一 的。
// 测试链接 : https://leetcode.cn/problems/gas-station/
public class hw4 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] record = new int[2 * n];
        for (int i = 0; i < n; i++) {
            record[i] = gas[i] - cost[i];
        }
        for (int i = n; i < 2 * n; i++) {
            record[i] = gas[i - n ] - cost[i - n ];
        }
        int cur = 0;
        int ans = -1;
        for (int l = 0, r = 0; l < n; r++) {
            cur += record[r];
            if (cur < 0) {
                cur = 0;
                l = r + 1;
            }
            if (r - l + 1 == n) {
                return l;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] gas = new int[]{2, 3, 4};
        int[] cost = new int[]{3, 4, 3};
        hw4 hw = new hw4();
        int word = hw.canCompleteCircuit(gas, cost);
        System.out.println(word);
    }
}
