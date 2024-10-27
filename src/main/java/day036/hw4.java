package day036;

public class hw4 {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }
    // 求二叉树的最大、最小深度
    // 测试链接 : https://leetcode.cn/problems/maximum-depth-of-binary-tree/

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = maxDepth(root.left);
        }
        if (root.right != null) {
            right = maxDepth(root.right);
        }
        return Math.max(left, right) + 1;

    }
    // 测试链接 : https://leetcode.cn/problems/minimum-depth-of-binary-tree/
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if (root.left != null) {
            left = minDepth(root.left);
        }
        if (root.right != null) {
            right = minDepth(root.right);
        }
        return Math.min(left, right) + 1;
    }

}
