package day045;

public class hw2plus {
    class Solution {
        public static int findMaximumXOR1(int[] nums) {
            build(nums);
            int ans = 0;
            for (int num : nums) {
                ans = Math.max(ans, maxXor(num));
            }
            clear();
            return ans;
        }
        public static int MAXN = 3000001;

        public static int[][] tree = new int[MAXN][2];

        // 前缀树目前使用了多少空间
        public static int cnt;

        // 数字只需要从哪一位开始考虑
        public static int high;
        public static int findMaximumXOR(int[] nums) {
            build(nums);
            int ans = 0;
            for (int num : nums) {
                ans = Math.max(ans, maxXor(num));
            }
            clear();
            return ans;
        }

        public static void build(int[] nums) {
            cnt = 1;
            // 找个最大值
            int max = Integer.MIN_VALUE;
            for (int num : nums) {
                max = Math.max(num, max);
            }
            // 计算数组最大值的二进制状态，有多少个前缀的0
            // 可以忽略这些前置的0，从left位开始考虑
            high = 31;
            for (int num : nums) {
                insert(num);
            }
        }

        public static void insert(int num) {
            int cur = 1;
            for (int i = high, path; i >= 0; i--) {
                path = (num >> i) & 1;
                if (tree[cur][path] == 0) {
                    tree[cur][path] = ++cnt;
                }
                cur = tree[cur][path];
            }
        }

        public static int maxXor(int num) {
            // 最终异或的结果(尽量大)
            int ans = 0;
            // 前缀树目前来到的节点编号
            int cur = 1;
            for (int i = high, status, want; i >= 0; i--) {
                // status : num第i位的状态
                status = (num >> i) & 1;
                // want : num第i位希望遇到的状态
                want = status ^ 1;
                if (tree[cur][want] == 0) { // 询问前缀树，能不能达成
                    // 不能达成
                    want ^= 1;
                }
                // want变成真的往下走的路
                ans |= (status ^ want) << i;
                cur = tree[cur][want];
            }
            return ans;
        }
        public static void clear() {
            for (int i = 1; i <= cnt; i++) {
                tree[i][0] = tree[i][1] = 0;
            }
        }
    }
}
