package day036;

import java.time.chrono.MinguoDate;

// 二叉树按层序列化和反序列化
// 测试链接 : https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/
public class hw6 {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int v) {
            val = v;
        }
    }
    // 队列的实现
    TreeNode[] queue = new TreeNode[10001];
    int l =0, r = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return sb.toString();
        }
        queue[r++] = root;
        sb.append(root.val + ",");
        while (l < r) {
            // 注意这里的写法，不能出队列在结算，而是进去九结算，因为空不进去，没办法
            TreeNode cur = queue[l++];
            if (cur.left != null) {
                sb.append(cur.left.val + ",");
                queue[r++] = cur.left;
            } else {
                sb.append("#,");
            }
            if (cur.right != null) {
                sb.append(cur.right.val + ",");
                queue[r++] = cur.right;
            } else {
                sb.append("#,");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        String[] dat = data.split(",");
        l = r = 0;
        int index = 0;
        TreeNode root = generate(dat[index++]);
        queue[r++] = root;
        while (l < r) {
            TreeNode cur = queue[l++];
            cur.left = generate(dat[index++]);
            cur.right = generate(dat[index++]);
            if (cur.left != null) {
                queue[r++] = cur.left;
            }
            if (cur.right != null) {
                queue[r++] = cur.right;
            }
        }
        return root;
    }
    // 生成一个结点
    private TreeNode generate(String val) {
        return val.equals("#") ? null : new TreeNode(Integer.valueOf(val));
    }

}
