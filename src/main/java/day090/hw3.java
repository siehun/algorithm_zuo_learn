package day090;

import java.util.Arrays;

public class hw3 {
    public static int maxMeeting2(int[][] meeting) {
        Arrays.sort(meeting, (a, b) -> a[1] - b[1]);
        int n = meeting.length;
        int ans = 0;
        int cur = -1;
        for (int i = 0; i < n; i++) {
            if (cur <= meeting[i][0]) {
                ans++;
                cur = meeting[i][1];
            }
        }
        return ans;
    }
    public static int maxMeeting1(int[][] meeting) {
        return f(meeting,meeting.length, 0);
    }
    public static void swap(int[][] meeting, int i, int j) {
        int[] temp = meeting[i];
        meeting[i] = meeting[j];
        meeting[j] = temp;
    }
    public static int f(int[][] meeting, int len, int i) {
        int ans = 0;
        if (i == len) {
            int cur = -1;
            for (int j = 0;j < len; j++) {
                if (cur <= meeting[j][0]) {
                    cur = meeting[j][1];
                    ans++;
                }
            }
        } else {
            for (int j = i; j < len; j++) {
                swap(meeting, i, j);
                ans = Math.max(ans, f(meeting, len, i + 1));
                swap(meeting, i, j);
            }

        }
        return ans;
    }
    public static void main(String[] args) {
        int N = 10;
        int M = 12;
        int testTimes = 2000;
        System.out.println("=====");
        for (int i = 1; i <= testTimes; i++) {
            int n = (int) (Math.random() * N) + 1;
            int[][] meeting = randomMeeting(n, M);
            int ans1 = maxMeeting1(meeting);
            int ans2 = maxMeeting2(meeting);
            if (ans1 != ans2) {
                System.out.println("false");
            }
        }
        System.out.println("===========");
    }
    public static int[][] randomMeeting(int n, int M) {
        return new int[][]{};
    }
}
