package day034;
// 每k个节点一组翻转链表
// 测试链接：https://leetcode.cn/problems/reverse-nodes-in-k-group/
public class hw2 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode teamEnd(ListNode start, int k) {
        while (--k != 0 && start != null) {
            start = start.next;
        }
        return start;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end = teamEnd(start, k);
        if (end == null) {
            return head;
        }
        head = end;
        reverseList(start, end);
        ListNode lastEnd = start;
        while (lastEnd.next != null) {
            start = lastEnd.next;
            end = teamEnd(start, k);
            if (end == null) {
                return head;
            }
            reverseList(start, end);
            lastEnd.next = end;
            lastEnd = start;
        }
        return head;
    }
    public void reverseList(ListNode start, ListNode end) {
        ListNode pre = null;
        ListNode cur = start;
        end = end.next;
        while (cur != end) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end;
    }
}
