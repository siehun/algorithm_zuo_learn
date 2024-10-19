package day027;

import java.util.Arrays;
import java.util.PriorityQueue;

// 测试链接 : https://leetcode.cn/problems/meeting-rooms-ii/
// 请同学们务必参考如下代码中关于输入、输出的处理
// 这是输入输出处理效率很高的写法
// 提交以下的code，提交时请把类名改成"Main"，可以直接通过
public class hw2 {
    public int minMeetingRooms(int[][] intervals) {
        // 重合已左边界为开始,那么需要遍历左边界
        Arrays.sort(intervals, (a, b)->a[0] - b[0]);
        //
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int n = intervals.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int begin = intervals[i][0];
            int end = intervals[i][1];
            while (heap.size() > 0 && heap.peek() <= begin) {
                heap.poll();
            }
            heap.add(end);
            ans = Math.max(ans, heap.size());
        }
        return ans;
    }
}
