package day030;

public class hw3 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xor1 = 0;
        for (int i = 0; i <= n; i++) {
            xor1 ^= i;
        }
        int xor2 = 0;
        for (int i = 0; i < n; i++) {
            xor2 ^= nums[i];
        }
        return xor2 ^ xor1;
    }
}
