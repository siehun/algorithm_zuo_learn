package day015;

import java.util.Stack;

//最小栈
// 测试链接 : https://leetcode.cn/problems/min-stack/
public class hw1 {
    class MinStack1 {
        Stack<Integer> data;
        Stack<Integer> min;

        public MinStack1() {
            data = new Stack<>();
            min = new Stack<>();
        }

        public void push(int val) {
            data.push(val);
            if (min.isEmpty()) {
                min.push(val);
            } else {
                int cur = val <= min.peek() ? val : min.peek();
                min.push(cur);
            }
        }
        public void pop() {
            data.pop();
            min.pop();
        }

        public int top() {
            return data.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }
    class MinStack {
        int[] data;
        int[] min;
        int size;

        public MinStack() {
            size = 0;
            data = new int[8081];
            min = new int[8081];
        }

        public void push(int val) {
            if (size == 0) {
                data[size] = val;
                min[size++] = val;
            } else {
                data[size] = val;
                int cur = min[size - 1] <= val ? min[size - 1] : val;
                min[size++] = cur;
            }
        }

        public void pop() {
            size--;
        }

        public int top() {
            return data[size-1];
        }

        public int getMin() {
            return min[size-1];
        }
    }
}
