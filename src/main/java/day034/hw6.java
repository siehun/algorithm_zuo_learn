package day034;
// 排序链表
// 要求时间复杂度O(n*logn)，额外空间复杂度O(1)，还要求稳定性
// 数组排序做不到，链表排序可以
// 测试链接 : https://leetcode.cn/problems/sort-list/
public class hw6 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode findEnd(ListNode h , int k) {
        while (--k != 0&& h.next != null) {
            h = h.next;
        }
        return h;
    }
    public int count(ListNode h) {
        int ans = 0;
        while (h != null) {
            ans++;
            h = h.next;
        }
        return ans;
    }
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int n = count(head);
        ListNode l1, r1, l2, r2, next, lastTeamEnd;
        for (int step = 1; step < n; step <<= 1) {
            l1 = head;
            r1 = findEnd(l1, step);
            l2 = r1.next;
            r2 = findEnd(l2, step);
            next = r2.next;
            r1.next = null;
            r2.next = null;
            merge(l1, r1, l2, r2);
            head = start;
            lastTeamEnd = end;
            while (next != null) {
                l1 = next;
                r1 = findEnd(l1, step);
                l2 = r1.next;
                if (l2 == null) {
                    lastTeamEnd.next = l1;
                    break;
                }
                r2 = findEnd(l2, step);
                next = r2.next;
                r1.next = null;
                r2.next = null;
                merge(l1, r1, l2, r2);
                lastTeamEnd.next = start;
                lastTeamEnd = end;
            }
        }
        return head;
    }
    public  ListNode start;
    public  ListNode end;
    public  void merge(ListNode l1, ListNode r1, ListNode l2, ListNode r2) {
        ListNode pre;
        if (l1.val <= l2.val) {
            start = l1;
            pre = l1;
            l1 = l1.next;
        } else {
            start = l2;
            pre = l2;
            l2 = l2.next;
        }
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                pre = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                pre = l2;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            pre.next = l1;
            end = r1;
        } else {
            pre.next = l2;
            end = r2;
        }
    }
}
