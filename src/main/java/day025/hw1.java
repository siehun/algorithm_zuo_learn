package day025;

// 堆结构和堆排序，填函数练习风格
// 测试链接 : https://leetcode.cn/problems/sort-an-array/
public class hw1 {
    //heapInsert, 大根堆,往上调整
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public void heapInsert(int[] nums, int xi) {
        while (nums[xi] > nums[(xi - 1) / 2]) {
            swap(nums, xi, (xi - 1) / 2);
            xi = (xi - 1) / 2;
        }
    }

    //heapify,往下调整
    public void heapify(int[] nums, int xi, int size) {
        int l = xi * 2 + 1;
        while (l < size) {
            int best = l + 1 < size && nums[l + 1] > nums[l] ? l + 1 : l;
            best = nums[best] > nums[xi] ? best : xi;
            if (best == xi) {
                break;
            }
            swap(nums, best, xi);
            xi = best;
            l = xi * 2 + 1;
        }

    }


    //heapsort，堆排序
    public void heapsort1(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            heapInsert(nums, i);
        }
        int size = n;
        while (size > 1) {
            swap(nums, 0, --size);
            heapify(nums, 0, size);
        }
    }
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        if (n > 1) {
            heapsort2(nums);
        }
        return nums;
    }
    public void heapsort2(int[] nums) {
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            heapify(nums, i, n);
        }
        int size = n;
        while (size > 1) {
            swap(nums, 0, --size);
            heapify(nums, 0, size);
        }
    }



}
