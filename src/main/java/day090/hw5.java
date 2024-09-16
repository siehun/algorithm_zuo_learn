package day090;

import java.util.PriorityQueue;

public class hw5 {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> capit = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        PriorityQueue<int[]> pro = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        int len = profits.length;
        for (int i = 0; i < len; i++) {
            capit.add(new int[] {capital[i], profits[i]});
        }
        for (int i = 0; i < k; i++) {
            while (!capit.isEmpty() && capit.peek()[0] <= w) {
                pro.add(capit.poll());
            }
            if (!pro.isEmpty()) {
                w += pro.poll()[1];
            }
        }
        return w;




    }
}
