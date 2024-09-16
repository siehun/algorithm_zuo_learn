package day011;
// 给你两个 非空 的链表，表示两个非负的整数
// 它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字
// 请你将两个数相加，并以相同形式返回一个表示和的链表。
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头
// https://leetcode.com/problems/add-two-numbers/description/
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = null, cur = null;
        int carry = 0;
        for (;
            l1 != null || l2 != null;
            l1 = l1 == null ? null : l1.next,
            l2 = l2 == null ? null : l2.next)
        {
            int sum = (l1 == null ? 0 : l1.val) +
                    (l2 == null ? 0 : l2.val) + carry;
            int val = sum % 10;
            carry = sum / 10;
            if (ans == null) {
                ans = new ListNode(val);
                cur = ans;
            } else {
                cur.next = new ListNode(val);
                cur = cur.next;
            }
        }
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return ans;
    }
}
