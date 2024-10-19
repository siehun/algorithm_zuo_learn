package day027;

import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.cn/problems/merge-k-sorted-lists/
//合并k个升序链表
public class hw1 {
    public class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int v) {
            val = v;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b) -> a.val - b.val);
        for (ListNode h : lists) {
            if (h != null) {
                heap.add(h);
            }
        }
        if (heap.isEmpty()) {
            return null;
        }
        ListNode h = heap.poll();
        ListNode pre = h;
        if (pre.next != null) {
            heap.add(pre.next);
        }
        while (!heap.isEmpty()) {
            ListNode cur = heap.poll();
            pre.next = cur;
            pre = cur;
            if (cur.next != null) {
                heap.add(cur.next);
            }
        }
        return h;
    }
}
