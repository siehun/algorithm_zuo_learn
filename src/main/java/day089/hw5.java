package day089;

import java.util.Arrays;
import java.util.PriorityQueue;

public class hw5 {
    public int scheduleCourse(int[][] courses) {
        //
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b- a);
        int time = 0;
        for (int[] course : courses) {
            int last = course[0];
            int ddl = course[1];
            if (time + last <= ddl) {
                time += last;
                heap.add(last);
            } else {
                if (!heap.isEmpty()&& last < heap.peek()) {
                    time += (last - heap.poll());
                    heap.add(last);
                }

            }
        }
        return heap.size();


    }
}
