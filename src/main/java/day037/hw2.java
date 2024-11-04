package day037;
// 搜索二叉树上寻找两个节点的最近公共祖先
// 测试链接 : https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/
public class hw2 {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pval = p.val;
        int qval = q.val;
        if (root.val > Math.min(pval, qval) && root.val < Math.max(pval, qval)) {
            return root;
        }
        if (root.val < pval && root.val < qval) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if (root.val > pval && root.val > qval) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }
}
