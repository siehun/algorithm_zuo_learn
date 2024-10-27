package day035;

import java.util.PriorityQueue;

// 快速获得数据流的中位数的结构
public class hw5 {
    // 测试链接 : https://leetcode.cn/problems/find-median-from-data-stream/
    class MedianFinder {
        PriorityQueue<Integer> max;
        PriorityQueue<Integer> min;

        public MedianFinder() {
            max = new PriorityQueue<>((a, b)->(b - a));
            min = new PriorityQueue<>((a, b)->(a -b));
        }

        public void addNum(int num) {
            if (max.size() == 0 && min.size() == 0) {
                max.add(num);
                return;
            }
            if (num <= max.peek()) {
                max.add(num);
            } else {
                min.add(num);
            }
            if (Math.abs(max.size() - min.size()) > 1) {
                if (max.size() > min.size()) {
                    min.add(max.poll());
                } else {
                    max.add(min.poll());
                }
            }
        }

        public double findMedian() {
            if(max.size() > min.size()) {
                return max.peek();
            } else if (min.size() > max.size()) {
                return min.peek();
            } else {
                return (double)(max.peek() + min.peek()) / 2;
            }
        }
    }
}
