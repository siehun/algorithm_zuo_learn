package day046;
// 利用前缀和快速得到区域累加和
// 测试链接 : https://leetcode.cn/problems/range-sum-query-immutable/

// 题目是求数组某一个范围的数字之和
public class hw1 {
    class NumArray {
        public int[] arr;
        public int[] sum;

        public NumArray(int[] nums) {
            int n = nums.length;
            arr = new int[n];
            sum = new int[n];
            sum[0] = nums[0];
            for (int i = 0; i < n; i++) {
                arr[i] = nums[i];
                if (i != 0) {
                    sum[i] = sum[i - 1] + nums[i];
                }
            }
        }
        public int sumRange(int left, int right) {
            return left != 0 ? sum[right] - sum[left - 1] : sum[right];
        }
    }
}
