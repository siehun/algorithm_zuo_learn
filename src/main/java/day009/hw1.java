package day009;

import java.util.List;
// 单链表的反转
// https://leetcode.com/problems/reverse-linked-list/description/
public class hw1 {
    class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    class DoubleListNode {
        public int val;
        public DoubleListNode last;
        public DoubleListNode next;
        public DoubleListNode(int v) {
            val = v;
        }
    }
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    public DoubleListNode reverseDoubleList(DoubleListNode head) {
        DoubleListNode pre = null;
        DoubleListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

}
