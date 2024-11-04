package day037;

import java.util.Stack;

// 验证搜索二叉树
// 测试链接 : https://leetcode.cn/problems/validate-binary-search-tree/
public class hw5 {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }
    public boolean isValidBST1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        boolean flag = true;
        while (root != null || stack.size() > 0) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (pre != null && pre.val >= root.val) {
                    flag = false;
                }
                pre = root;
                root = root.right;
            }
        }
        return flag;
    }
    public long min;
    public long max;
    public boolean isValidBST(TreeNode root) {
        // 左树是平和二叉树，右树是平衡二叉树，左树最大值小
        // 右树最小值大
        if (root == null) {
            min = Long.MAX_VALUE;
            max = Long.MIN_VALUE;
            return true;
        }
        boolean lok = isValidBST(root.left);
        long lmin = min;
        long lmax = max;
        boolean rok = isValidBST(root.right);
        long rmin = min;
        long rmax = max;
        min =Math.min(root.val, Math.min(lmin, rmin));
        max = Math.max(root.val,Math.max(lmax, rmax));
        return lok && rok && (root.val > lmax && root.val < rmin);
    }
}
