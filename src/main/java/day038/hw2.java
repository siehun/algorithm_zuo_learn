package day038;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的组合
// 答案 不能 包含重复的组合。返回的答案中，组合可以按 任意顺序 排列
// 注意其实要求返回的不是子集，因为子集一定是不包含相同元素的，要返回的其实是不重复的组合
// 比如输入：nums = [1,2,2]
// 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
// 测试链接 : https://leetcode.cn/problems/subsets-ii/
public class hw2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        f(nums, 0, new int[nums.length],0, ans);
        return ans;
    }
    public void f(int[] nums, int i, int[] path, int size,  List<List<Integer>> ans) {
        if (i == nums.length) {
            ArrayList<Integer> arr = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                arr.add(path[j]);
            }
            ans.add(arr);
        } else {
            int end = i + 1;
            while (end != nums.length && nums[end] == nums[end - 1]) {
                end++;
            }
            f(nums, end, path, size, ans);
            for (int start = i; start < end; start++) {
                path[size++] = nums[start];
                f(nums, end, path, size, ans);
            }
        }
    }
}
