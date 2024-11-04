package day036;

import java.util.HashMap;

// 利用先序与中序遍历序列构造二叉树
// 测试链接 : https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class hw7 {
    // 不提交这个类
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int v) {
            val = v;
        }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        if (preorder == null || inorder == null || preorder.length != inorder.length) {
//            return null;
//        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        int n = preorder.length;
        TreeNode root = f(preorder, 0, n - 1, inorder, 0, n - 1, map);
        return root;
    }


    public TreeNode f(int[] preorder, int pl, int pr, int[] inorder, int il, int ir, HashMap<Integer, Integer> map) {
        if(pl > pr) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pl]);
        if (pl == pr) {
            return root;
        }
        int k = map.get(preorder[pl]);
        root.left = f(preorder, pl + 1, pl + k - il, inorder, il, k - 1, map);
        root.right = f(preorder, pl + k - il + 1, pr, inorder, k + 1, ir, map);
        return root;
    }

}
