package day036;
// 二叉树的最大特殊宽度
// 测试链接 : https://leetcode.cn/problems/maximum-width-of-binary-tree/
public class hw3 {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }
    public int max = 3001;
    public TreeNode[] queue1 = new TreeNode[max];
    public int[] queue2 = new int[max];
    int l = 0, r = 0;
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        queue1[r] = root;
        queue2[r++] = 1;
        int ans = 0;
        while (l < r) {
            int size = r - l;
            ans = Math.max(ans, queue2[r - 1] - queue2[l] + 1);
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue1[l];
                if (cur.left != null) {
                    queue1[r] = cur.left;
                    queue2[r++] = queue2[l] * 2;
                }
                if (cur.right != null) {
                    queue1[r] = cur.right;
                    queue2[r++] = queue2[l] * 2 + 1;
                }
                l++;
            }
        }
        return ans;
    }
}
