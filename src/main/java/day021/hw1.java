package day021;
// 实现归并排序的递归版本和非递归版本
// 归并排序，填函数练习风格
// 测试链接 : https://leetcode.cn/problems/sort-an-array/
public class hw1 {
    public int[] sortArray(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        //mergeSort(nums, 0, nums.length - 1);
        int n = nums.length;
        // 步长从一开始，小于数组长度
        for (int step = 1; step < n; step <<= 1) {
            int l = 0;
            while (l < n) {
                int m = l + step - 1;
                if (m + 1 >= n) {
                    //如果没有右部分
                    break;
                }

                int r = Math.min(m + step, n - 1);
                merge(nums, l, m, r);
                l = r + 1;
            }
        }
        return nums;
    }
    public void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int m = r + ((l - r) >> 1);
        mergeSort(nums, l, m);
        mergeSort(nums, m + 1 , r);
        merge(nums, l, m , r);
    }
    public void merge(int[] nums, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = m + 1;
        int i = 0;
        while (p1 <= m && p2 <= r) {
            help[i++] = nums[p1] <= nums[p2] ? nums[p1++] : nums[p2++];
        }
        while (p1 <= m) {
            help[i++] = nums[p1++];
        }
        while (p2 <= r) {
            help[i++] = nums[p2++];
        }
        for (int j = 0; j < r - l + 1; j++) {
            nums[j + l] = help[j];
        }
    }




}
