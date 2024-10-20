package day030;
// 数组中有2种数出现了奇数次，其他的数都出现了偶数次
// 返回这2种出现了奇数次的数
// 测试链接 : https://leetcode.cn/problems/single-number-iii/
public class hw5 {
    public int[] singleNumber(int[] nums) {
        int xor1 = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            xor1 ^= nums[i];
        }
        int rightOne = xor1 & (~xor1 + 1);
        int xor2 = 0;
        for (int i = 0; i < n; i++) {
            if ((nums[i] & rightOne) == 0) {
                xor2 ^= nums[i];
            }
        }
        return new int[]{xor2, xor1 ^ xor2};
    }
}
