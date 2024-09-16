package day089;

import java.util.Arrays;
import java.util.PriorityQueue;

public class hw4 {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals,(a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int max = 0;
        for (int i = 0; i < intervals.length; i++) {
            int begin = intervals[i][0];
            int end = intervals[i][1];
            while (!heap.isEmpty() && heap.peek() <= begin ) {
                heap.poll();
            }
            heap.add(end);
            max = Math.max(max, heap.size());
        }
        return max;

    }
}
