package day037;
// 验证平衡二叉树
// 测试链接 : https://leetcode.cn/problems/balanced-binary-tree/
public class hw4 {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        height(root);
        return flag;
    }
    public int height(TreeNode root) {
        if (!flag || root == null) {
            return 0;
        }
        int l = height(root.left);
        int r = height(root.right);
        if (Math.abs(r - l) > 1) {
            flag = false;
        }
        return Math.max(l, r) + 1;
    }
}
