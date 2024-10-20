package day030;
// 返回出现了奇数次的数
// 测试链接 : https://leetcode.cn/problems/single-number/
public class hw4 {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        return xor;
    }
}
