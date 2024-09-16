package day092;

import java.util.TreeSet;

public class hw1 {
    public int minimumDeviation(int[] nums) {

        TreeSet<Integer> set = new TreeSet<>();
        for (int i : nums) {
            if (i % 2 == 0) {
                set.add(i);
            } else {
                set.add(i * 2);
            }
        }
        int ans = set.last() - set.first();
        while (ans > 0 && set.last() % 2 == 0) {
            int max = set.pollLast();
            set.add(max / 2);
            ans = Math.min(ans, set.last() - set.first());
        }
        return ans;
    }
}
