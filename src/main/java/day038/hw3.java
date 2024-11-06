package day038;

import java.util.ArrayList;
import java.util.List;

// 没有重复项数字的全排列
// 测试链接 : https://leetcode.cn/problems/permutations/
public class hw3 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        f(nums, 0, ans);
        return ans;
    }
    public void f(int[] nums, int i, List<List<Integer>> ans) {
        if (i == nums.length) {
            List<Integer> arr = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                arr.add(nums[j]);
            }
            ans.add(arr);
        } else {
            for (int j = i; j < nums.length; j++) {
                swap(nums, i, j);
                f(nums, i + 1, ans);
                swap(nums, i, j);
            }
        }
    }
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
