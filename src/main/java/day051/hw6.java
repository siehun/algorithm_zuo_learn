package day051;
// 完成旅途的最少时间(题目6的在线测试)
// 有同学找到了在线测试链接，和课上讲的题目6几乎是一个意思，但是有细微差别
// 实现的代码，除了一些变量需要改成long类型之外，仅有两处关键逻辑不同，都打上了注释
// 除此之外，和课上讲的题目6的实现，再无区别
// 可以仔细阅读如下测试链接里的题目，重点关注此题和题目6，在题意上的差别
// 测试链接 : https://leetcode.cn/problems/minimum-time-to-complete-trips/

import java.util.Comparator;
import java.util.PriorityQueue;

public class hw6 {
    public long minimumTime1(int[] time, int totalTrips) {
        PriorityQueue<long[]> heap = new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if (o1[0] + o1[1] < o2[0] + o2[1]) {
                    return -1;
                }
                return 1;
            }
        });
        for (int i = 0; i < time.length; i++) {
            heap.add(new long[]{0, time[i]});
        }
        long ans = 0;
        for (int i = 0; i < totalTrips; i++) {
            long[] cur = heap.poll();
            cur[0] += cur[1];
            ans = cur[0];
            heap.add(cur);
        }
        return ans;

    }
    public long minimumTime(int[] time, int totalTrips) {
        long l = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < time.length; i++) {
            min = Math.min(min, time[i]);
        }
        long r = (long)min * totalTrips;
        long ans = 0;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (f(time, mid, totalTrips)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
    public boolean f(int[] times, long time, int total) {
        long ans = 0;
        for (int i = 0; i < times.length; i++) {
            long cur = (time / times[i]);
            ans += cur;
        }
        return ans >= total;
    }


    public static void main(String[] args) {
//        int[] arr = new int[]{9, 2};
//        int total = 8;
//        hw5 hw = new hw5();
//        long ans = hw.minimumTime1(arr, total);
//        System.out.println(hw.minimumTime1(arr, total));
        int[] arr = new int[]{1,2,3};
        int total = 5;
        hw6 hw = new hw6();
        long ans = hw.minimumTime(arr, total);
        System.out.println(ans);
    }
}
