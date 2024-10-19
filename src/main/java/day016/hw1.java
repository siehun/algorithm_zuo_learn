package day016;

import java.util.Deque;
import java.util.LinkedList;

// 设计循环双端队列
// 测试链接 : https://leetcode.cn/problems/design-circular-deque/
public class hw1 {
    class MyCircularDeque1 {
        public Deque<Integer> deque;
        public int limit;
        public int size;

        public MyCircularDeque1(int k) {
            size = 0;
            limit = k;
            deque = new LinkedList<>();
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            deque.offerFirst(value);
            size++;
            return true;

        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            deque.offerLast(value);
            size++;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            deque.pollFirst();
            size--;
            return true;

        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            deque.pollLast();
            size--;
            return true;
        }

        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            return deque.getFirst();
        }

        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            return deque.getLast();
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }
    }

    class MyCircularDeque {
        public int size;
        public int limit;
        public int l, r;
        public int[] queue;

        public MyCircularDeque(int k) {
            l = r = 0;
            size = 0;
            limit = k;
            queue = new int[k];
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            if (isEmpty()) {
                l = r = 0;
                queue[l] = value;
                size++;
                return true;
            }
            l = l == 0 ? limit - 1 : l - 1;
            queue[l] = value;
            size++;
            return true;

        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            if (isEmpty()) {
                l = r = 0;
                queue[r] = value;
                size++;
                return true;
            }
            r = r == limit - 1 ? 0 : r + 1;
            queue[r] = value;
            size++;
            return true;


        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            l = l == limit - 1 ? 0 : l + 1;
            size--;
            return true;

        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            r = r == 0 ? limit - 1 : r - 1;
            size--;
            return true;

        }

        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            return queue[l];
        }

        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            return queue[r];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;

        }
    }


}
