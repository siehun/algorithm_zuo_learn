package day018;

import day012.hw1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class hw2 {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int v) {
            val = v;
        }
    }
    // https://leetcode.cn/problems/binary-tree-preorder-traversal/
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();
                res.add(cur.val);
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }
        return res;
    }
    // 中序，如果要做到中序
    // 对于每个结点，先处理最左边，在处理最右边
    // 测试链接 : https://leetcode.cn/problems/binary-tree-inorder-traversal/
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    res.add(root.val);
                    root = root.right;
                }
            }
        }
        return res;
    }


    // 用两个栈完成后序遍历
    // 提交时函数名改为postorderTraversal
    // 测试链接 : https://leetcode.cn/problems/binary-tree-postorder-traversal/
    public static List<Integer> postorderTraversalTwoStacks(TreeNode head) {
        List<Integer> ans = new ArrayList<>();
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            Stack<TreeNode> collect = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                collect.push(head);
                if (head.left != null) {
                    stack.push(head.left);
                }
                if (head.right != null) {
                    stack.push(head.right);
                }
            }
            while (!collect.isEmpty()) {
                ans.add(collect.pop().val);
            }
        }
        return ans;
    }

    // 如果始终没有打印过节点，h就一直是头节点
    // 一旦打印过节点，h就变成打印节点
    // 之后h的含义 : 上一次打印的节点
    // https://leetcode.cn/problems/binary-tree-postorder-traversal/
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode cur = stack.peek();
                if (cur.left != null && cur.left != root && cur.right != root) {
                    stack.push(cur.left);
                } else if (cur.right != null && cur.right != root) {
                    stack.push(cur.right);
                } else {
                    res.add(cur.val);
                    root = stack.pop();
                }
            }
        }
        return res;
    }


}
