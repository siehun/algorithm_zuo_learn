package day094;

import java.util.PriorityQueue;

public class hw3 {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> heap = new PriorityQueue<>((a,b) -> a[2] >= b[2] ? -1 : 1);
        for (int[] clas : classes) {
            double a = clas[0];
            double b = clas[1];
            heap.add(new double[] {a, b, (a + 1) / (b + 1) - a/ b});
        }
        for (int i = 0; i < extraStudents; i++) {
            double[] cur = heap.poll();
            heap.add(new double[]{cur[0] + 1, cur[1] + 1, (cur[0] + 2) / (cur[1] + 2) - (cur[0] + 1) / (cur[1] + 1)});
        }
        double ans = 0;
        while(!heap.isEmpty()) {
            double[] cur = heap.poll();
            ans += cur[0] / cur[1];
        }
        return ans/ classes.length;



    }
}
