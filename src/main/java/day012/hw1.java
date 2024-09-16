package day012;
// 给你一个链表的头节点 head 和一个特定值 x
// 请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
// 你应当 保留 两个分区中每个节点的初始相对位置
// 测试链接 : https://leetcode.com/problems/partition-list/
public class hw1 {
    public class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode partition(ListNode head, int x) {
        ListNode leftHead = null;
        ListNode leftTail = null;
        ListNode rightHead = null;
        ListNode rightTail = null;
        while (head != null) {
            ListNode node = new ListNode(head.val);
            if (head.val < x) {
                if (leftHead == null) {
                    leftHead = node;
                    leftTail = leftHead;
                } else {
                    leftTail.next = node;
                    leftTail = leftTail.next;
                }
            } else {
                if (rightHead == null) {
                    rightHead = node;
                    rightTail = rightHead;
                } else {
                    rightTail.next = node;
                    rightTail = rightTail.next;
                }
            }
            head = head.next;
        }
        if (leftHead == null) {
            return rightHead;
        }
        leftTail.next = rightHead;
        return leftHead;
    }
}
