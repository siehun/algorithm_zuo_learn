package day094;

import java.util.Arrays;
import java.util.PriorityQueue;

public class hw4 {
    public class employee {
        public double ratio;
        public double quality;
        public employee(double r, double q) {
            ratio = r;
            quality = q;
        }
    }
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        employee[] arr = new employee[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new employee((double)wage[i] / quality[i], (double)quality[i]);
        }
        Arrays.sort(arr, (a,b) -> a.ratio <= b.ratio ? -1 : 1);
        PriorityQueue<Double> heap = new PriorityQueue<>((a, b) -> a >= b ? -1 : 1);
        double ans = Double.MAX_VALUE;
        double sum = 0;
        for (int i = 0; i < n; i++) {
            if (heap.size() == k) {
                if (heap.peek() > arr[i].quality) {
                    sum += arr[i].quality - heap.poll();
                    heap.add(arr[i].quality);
                    ans = Math.min(ans, sum * arr[i].ratio);
                }

            } else {
                sum += arr[i].quality;
                heap.add(arr[i].quality);
                if (heap.size() == k) {
                    ans = Math.min(ans, sum * arr[i].ratio );
                }
            }

        }
        return ans;

    }
}
