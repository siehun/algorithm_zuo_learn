package day036;
// 二叉树先序序列化和反序列化
// 测试链接 : https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/
public class hw5 {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int v) {
            val = v;
        }
    }
    // 二叉树可以通过先序、后序或者按层遍历的方式序列化和反序列化
    // 但是，二叉树无法通过中序遍历的方式实现序列化和反序列化
    // 因为不同的两棵树，可能得到同样的中序序列，即便补了空位置也可能一样。
    // 比如如下两棵树
    //         __2
    //        /
    //       1
    //       和
    //       1__
    //          \
    //           2
    // 补足空位置的中序遍历结果都是{ null, 1, null, 2, null}
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        f(root, sb);
        return sb.toString();
    }
    public void f(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
        } else {
            sb.append(root.val + ",");
            f(root.left, sb);
            f(root.right, sb);
        }
    }
    public int cnt = 0;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dat = data.split(",");
        TreeNode root = f1(dat);
        return root;
    }
    public TreeNode f1(String[] data) {
        if (data[cnt].equals("#")) {
            cnt++;
            return null;
        }
        TreeNode cur = new TreeNode(Integer.valueOf(data[cnt++]));
        cur.left = f1(data);
        cur.right = f1(data);
        return cur;
    }

}
