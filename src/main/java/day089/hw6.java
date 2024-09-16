package day089;

import java.util.PriorityQueue;

public class hw6 {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < sticks.length; i++) {
            heap.add(sticks[i]);
        }
        int sum = 0;
        while(heap.size() > 1) {
            int cur = heap.poll() + heap.poll();
            sum += cur;
            heap.add(cur);
        }
        return sum;

    }
}
