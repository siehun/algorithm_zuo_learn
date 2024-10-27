package day036;

import java.util.ArrayList;
import java.util.List;

// 二叉树的层序遍历
// 测试链接 : https://leetcode.cn/problems/binary-tree-level-order-traversal/
public class hw1 {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }
    TreeNode[] que = new TreeNode[2001];
    int l =0 , r = 0;
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        que[r++] = root;
        List<List<Integer>> ans = new ArrayList<>();
        while (l < r) {
            int size = r - l;
            List<Integer> ceil = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = que[l++];
                ceil.add(cur.val);
                if (cur.left != null) {
                    que[r++] = cur.left;
                }
                if (cur.right != null) {
                    que[r++] = cur.right;
                }
            }
            ans.add(ceil);
        }
        return ans;
    }
}
