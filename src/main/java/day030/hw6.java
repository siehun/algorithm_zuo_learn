package day030;
// 数组中只有1种数出现次数少于m次，其他数都出现了m次
// 返回出现次数小于m次的那种数
// 测试链接 : https://leetcode.cn/problems/single-number-ii/
// 注意 : 测试题目只是通用方法的一个特例，课上讲了更通用的情况
public class hw6 {
    public int singleNumber(int[] nums) {
        return find(nums, 3);
    }
    public static int find(int[] arr, int m) {
        int[] cnts = new int[32];
        // 遍历记录位数
        for (int num : arr) {
            for (int i = 0; i < 32; i++) {
                cnts[i] += (num>>i) & 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (cnts[i] % m != 0) {
                ans |= 1 << i;
            }
        }
        return ans;
    }
}
