package day045;
// 数组中两个数的最大异或值
// 给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0<=i<=j<=n
// 1 <= nums.length <= 2 * 10^5
// 0 <= nums[i] <= 2^31 - 1
// 测试链接 : https://leetcode.cn/problems/maximum-xor-of-two-numbers-in-an-array/
import java.util.HashSet;

public class hw2 {

    public static int MAXN = 3000001;
    public static int[][] record = new int[MAXN][2];
    public static int cnt;
    public static int findMaximumXOR(int[] nums) {
        int ans = 0;
        cnt = 1;
        for (int i = 0; i < nums.length; i++) {
            insert(nums[i]);
        }
        for (int i = 0; i< nums.length; i++) {
            int n = nums[i];
            ans = Math.max(ans, f(n));
        }
        return ans;
    }
    public static int f(int n) {
        int cur = 1;
        int ans = 0;
        for (int i = 30; i>= 0; i--) {
            int a = (n >> i) & 1;
            int b = a == 0 ? 1 : 0;
            if (record[cur][b] != 0) {
                cur = record[cur][b];
                ans |= (1 << i);

            } else {
                cur = record[cur][a];
            }

        }
        return ans;
    }
    public static void insert(int n) {
        int cur = 1;
        for (int i = 30; i >= 0; i--) {
            int path = (n >> i) & 1;
            if (record[cur][path] == 0) {
                record[cur][path] = ++cnt;
            }
            cur = record[cur][path];
        }
    }

    public static void main(String[] args) {
        hw2 hw = new hw2();
        int[] arr = new int[]{20,12,29,76,94,65,95,33,79,80,57,78};
        System.out.println(hw.findMaximumXOR(arr));

    }
    public int findMaximumXOR1(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        HashSet<Integer> set = new HashSet<>();
        int ans = 0;
        for (int i = 31 - f1(max); i >= 0; i--) {
            set.clear();
            int better = ans | (1 << i);
            for (int num : nums) {
                int n = (num >> i) << i;
                set.add(n);
                if (set.contains(better ^ n)) {
                    ans = better;
                    break;
                }
            }
        }
        return ans;
    }
    public int f1(int n) {
        int ans = 0;
        for (int i = 31; i>=0; i--) {
            if (n >> i == 0) {
                ans++;
            } else {
                break;
            }
        }
        return ans;
    }
}
