package day037;
// 二叉树打家劫舍问题
// 测试链接 : https://leetcode.cn/problems/house-robber-iii/
public class hw7 {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }
    // 这个方法超时了，应该是没有错的，不过我增加了判断true，false,又开了两个分支，导致超时了
//    public int rob(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        // 不偷头节点
//        int no = f(root.left, false) + f(root.right, false);
//        // 偷头节点
//        int yes = root.val + f(root.left, true) + f(root.right, true);
//        return Math.max(no, yes);
//    }
//    public int f(TreeNode root, boolean last) {
//        if (root == null) {
//            return 0;
//        }
//        if (last) {
//            return f(root.left, false) + f(root.right, false);
//        }
//        int no = f(root.left, false) + f(root.right, false);
//        int yes = root.val + f(root.left, true) + f(root.right, true);
//        return Math.max(no, yes);
//    }

    // ans[0]不劫， ans[1]劫
    public int rob(TreeNode root) {
        int[] ans = f(root);
        return Math.max(ans[0], ans[1]);
    }
    public int[] f(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] lans = f(root.left);
        int[] rans = f(root.right);
        int yes = lans[0] + rans[0] + root.val;
        int no = Math.max(lans[0], lans[1]) + Math.max(rans[0], rans[1]);
        return new int[]{no, yes};
    }
}
