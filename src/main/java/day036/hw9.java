package day036;
// 求完全二叉树的节点个数
// 测试链接 : https://leetcode.cn/problems/count-complete-tree-nodes/
public class hw9 {
    // 不提交这个类
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return f(root, 1, mostLeft(root, 1));
    }
    public int f(TreeNode cur, int level, int h) {
        if (level == h) {
            return 1;
        }
        if (mostLeft(cur.right, level + 1) == h) {
            // 计算左边结点，递归右边
            return (1 << (h - level)) + f(cur.right, level + 1, h);
        } else {
            return (1 << (h - level - 1)) + f(cur.left, level + 1,h);
        }

    }

    public int mostLeft(TreeNode cur, int level) {
        while (cur != null) {
            level++;
            cur = cur.left;
        }
        return level - 1;
    }
}
