package day034;
// 判断链表是否是回文结构
// 测试链接 : https://leetcode.cn/problems/palindrome-linked-list/
public class hw4 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        ListNode pre = head, ppre = null;
        while (fast!=null && fast.next!=null){
            //注意这种设计方法，这样在一次循环后，pre会位于slow的前面，有利于下面的比较
            pre = slow;//pre跟踪slow的前一个位置，ppre跟踪pre的前一个位置
            slow = slow.next;
            fast = fast.next.next;
            pre.next = ppre;
            ppre = pre;
        }
        if (fast!=null)//这是奇数的情况，中间那个数不用比较，slow往下跳一步
            slow = slow.next;
        while (slow!=null){
            if (slow.val!= pre.val)
                return false;
            slow = slow.next;
            pre = pre.next;
        }
        return true;
    }

}
