package day014;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 栈和队列的相互实现
public class hw1 {

    // 测试链接 : https://leetcode.cn/problems/implement-queue-using-stacks/
    // 用栈实现队列

    class MyQueue {

        public Stack<Integer> in;
        public Stack<Integer> out;

        public MyQueue() {
            in = new Stack<>();
            out = new Stack<>();
        }
        // 倒数据
        // 满足两个条件:
        // 1) out空了，才能倒
        // 2) 如果倒数据, in 必须倒完


        // 比如倒3个，相当于把这三个排成队列序,
        // 那么这三个作为一个整体已经OK
        // 整体与整体之间构成队列序， 整体内部构成队列序
        // 那么队列实现完成
        public void inToOut() {
            if (out.isEmpty()) {
                while (!in.empty()) {
                    out.push(in.pop());
                }
            }
        }
        public void push(int x) {
            in.push(x);
            inToOut();
        }

        public int pop() {
            inToOut();
            return out.pop();
        }

        public int peek() {
            inToOut();
            return out.peek();
        }

        public boolean empty() {
            return in.isEmpty() && out.isEmpty();

        }
    }
    //用队列实现栈
    // 测试链接 : https://leetcode.cn/problems/implement-stack-using-queues/
    class MyStack {
        // 这道题有点递归的味道也有点插入排序的味道
        // 把插入前当成一个整理，调整顺序
        public Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            int size = queue.size();
            queue.offer(x);
            for (int i = 0; i < size; i++) {
                queue.offer(queue.poll());
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }


}
