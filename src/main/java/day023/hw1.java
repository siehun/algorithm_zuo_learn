package day023;
// 随机快速排序，填函数练习风格
// 测试链接 : https://leetcode.cn/problems/sort-an-array/
public class hw1 {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        if (n > 1) {
            quicksort2(nums, 0, n - 1);
        }
        return nums;
    }
    public void quicksort1(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int x = nums[l + (int)(Math.random() * (r - l + 1))];
        int mid = partition1(nums, l, r, x);
        quicksort1(nums,l , mid - 1);
        quicksort1(nums, mid + 1 , r);
    }
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public int partition1(int[] nums, int l, int r, int x) {
        int left = l;
        int xi = 0;
        for (int i = l; i <= r; i++) {
            if (nums[i] <= x) {
                swap(nums, left, i);
                // 交换完之后记一下交换后的位置
                if (nums[left] == x) {
                    xi = left;
                }
                left++;
            }
        }
        swap(nums, xi, left - 1);
        return left - 1;
    }
    public void quicksort2(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int x = nums[l + (int)(Math.random() * (r -l + 1))];
        int[] record =  partition2(nums, l, r, x);
        quicksort1(nums, l , record[0] - 1);
        quicksort1(nums, record[1] + 1, r);
    }
    public int[] partition2(int[] nums, int l, int r, int x) {
        int left = l;
        int right = r;
        for (int i = l; i <= right;) {
            if (nums[i] > x) {
                swap(nums, i, right--);
            } else if(nums[i] < x) {
                swap(nums,i++,left++);
            } else {
                i++;
            }
        }
        return new int[]{left, right};
    }
}
