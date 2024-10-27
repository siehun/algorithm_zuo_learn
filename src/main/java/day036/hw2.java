package day036;

import java.util.ArrayList;
import java.util.List;

// 二叉树的锯齿形层序遍历
// 测试链接 : https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/
public class hw2 {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }
    public TreeNode[] queue = new TreeNode[2001];
    public int l = 0, r = 0;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        queue[r++] = root;
        boolean reverse = false;
        while (l < r) {
            List<Integer> ceil = new ArrayList<>();
            int size = r - l;
            if (!reverse) {
                for (int i = l; i < r; i++) {
                    ceil.add(queue[i].val);
                }
            } else {
                for (int i = r - 1; i >= l; i--) {
                    ceil.add(queue[i].val);
                }
            }
            ans.add(ceil);
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue[l++];
                if (cur.left != null) {
                    queue[r++] = cur.left;
                }
                if (cur.right != null)  {
                    queue[r++] = cur.right;
                }
            }
            reverse = !reverse;
        }
        return ans;
    }
}
