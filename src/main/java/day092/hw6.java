package day092;

import java.util.PriorityQueue;

public class hw6 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int curFuel = startFuel;
        int ans = 0;
        if (startFuel >= target) {
            return 0;
        }
        for (int[] station : stations) {
            while (station[0] > curFuel && !heap.isEmpty()) {
                curFuel += heap.poll()[1];
                ans++;
            }
            if (curFuel >= target) {
                return ans;
            }
            if (station[0] > curFuel) {
                return -1;
            }
            if (station[0] <= curFuel) {
                heap.add(station);
            }
        }
        while (!heap.isEmpty() && curFuel < target) {
            curFuel += heap.poll()[1];
            ans++;
            if (curFuel >= target) {
                return ans;
            }
        }
        return -1;

    }
}
