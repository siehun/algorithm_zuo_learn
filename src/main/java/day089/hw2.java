package day089;

import java.util.Arrays;

public class hw2 {
    public int twoCitySchedCost(int[][] costs) {
        int sum = 0;
        for (int i = 0; i < costs.length; i++) {
            sum += costs[i][0];
        }
        Arrays.sort(costs, (a, b) -> ((b[0] - b[1]) - (a[0] - a[1])));
        for (int i = 0; i < costs.length / 2; i++) {
            sum -= (costs[i][0] - costs[i][1]);
        }
        return sum;

    }
}
