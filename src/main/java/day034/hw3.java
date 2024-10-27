package day034;
// 复制带随机指针的链表
// 测试链接 : https://leetcode.cn/problems/copy-list-with-random-pointer/
public class hw3 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        // 构造a - a' 形式
        Node cur = head;
        while (cur != null) {
            Node node = new Node(cur.val);
            node.next = cur.next;
            cur.next = node;
            cur = cur.next.next ;
        }

        //连接random指针
        Node one = head;
        Node two = head.next;
        while (one != null) {
            Node oneTo = one.random;
            if (oneTo == null) {
                two.random = null;
            } else {
                two.random = oneTo.next;
            }
            if (two.next == null) {
                break;
            }
            one = one.next.next;
            two = two.next.next;
        }
        //拆开
        one = head;
        two = head.next;
        Node ret = two;
        while (one != null) {
            if (two.next == null) {
                break;
            }
            one.next = two.next;
            two.next = two.next.next;
            one = one.next;
            two = two.next;
        }
        one.next = null;
        return ret;

    }
}
