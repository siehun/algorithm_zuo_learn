package day013;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 栈和队列的实现
// 内部实现，数组实现，循环队列的设计
public class hw1 {
    public static class Queue1 {
        // 双向链表实现
        public Queue<Integer> queue = new LinkedList<>();

        // 判断是否为空
        public boolean isEmpty() {
            return queue.isEmpty();
        }

        // 队列加入num
        public void offer(int num) {
            queue.offer(num);
        }
        //队列拿数
        public int poll() {
            return queue.poll();
        }
        // 返回队列头
        public int peek() {
            return queue.peek();
        }

        // 返回队列里有几个数
        public int size() {
            return queue.size();
        }
    }
    // 数组实现 [l - r)
    public static class Queue2 {
        public int[] queue;
        public int l;
        public int r;
        public Queue2(int n) {
            queue = new int[n];
            l = 0;
            r = 0;
        }
        public boolean isEmpty() {
            return l == r;
        }
        public void offer(int num) {
            queue[r++] = num;
        }
        public int poll() {
            return queue[l++];
        }
        public int head() {
            return queue[l];
        }
        public int tail() {
            return queue[r - 1];
        }
        public int size() {
            return r - l;
        }
    }
    public static class Stack1 {
        public Stack<Integer> stack = new Stack<>();

        public boolean isEmpty() {
            return stack.isEmpty();
        }
        public void push(int num) {
            stack.push(num);
        }
        public int pop() {
            return stack.pop();
        }
        public int peek() {
            return stack.peek();
        }
        public int size() {
            return stack.size();
        }
    }
    public static class Stack2 {
        public int[] stack;
        public int size;
        public Stack2(int n) {
            stack = new int[n];
            size = 0;
        }
        public boolean isEmpty() {
            return size == 0;
        }
        public void push(int num) {
            stack[size++] = num;
        }
        public int pop() {
            return stack[--size];
        }
        public int peek() {
            return stack[size - 1];
        }
        public int size() {
            return size;
        }
    }
    // 设计循环队列
    // 测试链接 : https://leetcode.cn/problems/design-circular-queue/
    class MyCircularQueue {
        int[] queue;
        int limit;
        int l;
        int r;
        int size;

        public MyCircularQueue(int k) {
            queue = new int[k];
            limit = k;
            l = r = 0;
            size = 0;
        }

        public boolean enQueue(int value) {
            if (size < limit) {
                queue[r] = value;
                r = r == limit - 1 ? 0 :(r + 1);
                size++;
                return true;
            }
            return false;
        }

        public boolean deQueue() {
            if (size > 0) {
                l = l == limit - 1 ? 0 : (l + 1);
                size--;
                return true;
            }
            return false;

        }

        public int Front() {
            if (size == 0) {
                return -1;
            }
            return queue[l];

        }

        public int Rear() {
            if (size == 0) {
                return -1;
            }
            int last = r == 0 ? (limit - 1) : (r - 1);
            return queue[last];

        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }
    }
}
