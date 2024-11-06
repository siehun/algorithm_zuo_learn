package day037;

import java.util.ArrayList;
import java.util.*;

// 收集累加和等于aim的所有路径
// 测试链接 : https://leetcode.cn/problems/path-sum-ii/
public class hw3 {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        f(root, targetSum,0, path, ans);
        return ans;
    }
    public void f(TreeNode root, int targetSum, int sum, List<Integer> path, List<List<Integer>> ans) {
        if (root.left == null && root.right == null) {
            if (targetSum == sum + root.val) {
                path.add(root.val);
                copy(ans, path);
                path.remove(path.size() - 1);
            }
        } else {
            sum += root.val;
            path.add(root.val);
            if (root.left != null) {
                f(root.left, targetSum, sum, path, ans);
            }
            if (root.right != null) {
                f(root.right, targetSum, sum, path, ans);
            }
            path.remove(path.size() - 1);
        }
    }
    public void copy(List<List<Integer>> ans, List<Integer> list) {
        List<Integer> li = new ArrayList<>();
        for (Integer num : list) {
            li.add(num);
        }
        ans.add(li);
    }
}
