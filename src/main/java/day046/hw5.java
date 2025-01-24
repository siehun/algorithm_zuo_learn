package day046;

import java.util.HashMap;

// 表现良好的最长时间段
// 给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数
// 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是 劳累的一天
// 所谓 表现良好的时间段 ，意味在这段时间内，「劳累的天数」是严格 大于 不劳累的天数
// 请你返回 表现良好时间段 的最大长度
// 测试链接 : https://leetcode.cn/problems/longest-well-performing-interval/
public class hw5 {
    public int longestWPI(int[] hours) {
        int n = hours.length;
        int[] arr  = new int[n];
        for (int i = 0; i < n; i++) {
            if (hours[i] > 8) {
                arr[i] = 1;
            } else {
                arr[i] = -1;
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxlen = 0;
        for (int i = 0, sum = 0; i < n; i++) {
            sum += arr[i];
            if (sum > 0) {
                maxlen = i + 1;
            } else {
                int aim = sum - 1;
                if (map.containsKey(aim)) {
                    maxlen = Math.max(maxlen, i - map.get(aim));
                }
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxlen;

    }
}
