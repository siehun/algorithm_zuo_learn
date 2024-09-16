package day090;

import java.util.Arrays;
import java.util.PriorityQueue;

public class hw4 {
    public int maxEvents(int[][] events) {
        PriorityQueue<int[]> heap1 = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        PriorityQueue<int[]> heap2 = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int[] event : events) {
            min = Math.min(event[0], min);
            max = Math.max(event[1], max);
            heap2.add(event);
        }
        int ans = 0;
        for (int i = min; i <= max; i++) {
            while (!heap1.isEmpty() && heap1.peek()[1] < i) {
                heap1.poll();
            }
            while (!heap2.isEmpty() && heap2.peek()[0] <= i) {
                heap1.add(heap2.poll());
            }
            if (!heap1.isEmpty()) {
                heap1.poll();
                ans++;
            }

        }
        return ans;


    }
}
