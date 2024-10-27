package day036;

import day027.hw1;

// 验证完全二叉树
// 测试链接 : https://leetcode.cn/problems/check-completeness-of-a-binary-tree/
public class hw8 {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }
    int MAXN = 1001;
    TreeNode[] queue = new TreeNode[MAXN];
    int l = 0, r = 0;
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean flag = false;
        queue[r++] = root;
        while (l < r) {
            TreeNode cur = queue[l++];
            if ((cur.right != null && cur.left == null) || (flag && !(cur.left == null && cur.right == null))) {
                return false;
            }
            if (cur.left != null) {
                queue[r++] = cur.left;
            }
            if (cur.right != null) {
                queue[r++] = cur.right;
            }
            if (cur.left == null || cur.right == null) {
                flag = true;
            }
        }
        return true;

    }
}
