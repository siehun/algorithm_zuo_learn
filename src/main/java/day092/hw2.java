package day092;

import java.util.Arrays;

public class hw2 {
    public int numRabbits(int[] answers) {
        Arrays.sort(answers);
        int len = answers.length;
        int cnt = 1;
        int ans = 0;
        for (int i = 1; i < len; i++) {
            if (answers[i] != answers[i - 1]) {
                ans += (cnt + answers[i - 1] ) / (answers[i - 1] + 1) * (answers[i - 1] + 1);
                cnt = 1;
            } else {
                cnt++;
            }

        }
        ans +=(cnt + answers[len - 1]) / (answers[len - 1] + 1) * (answers[len - 1] + 1);
        return ans;

    }
}
