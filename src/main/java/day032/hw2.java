package day032;
// 位图的实现
// Bitset是一种能以紧凑形式存储位的数据结构
// Bitset(int n) : 初始化n个位，所有位都是0
// void fix(int i) : 将下标i的位上的值更新为1
// void unfix(int i) : 将下标i的位上的值更新为0
// void flip() : 翻转所有位的值
// boolean all() : 是否所有位都是1
// boolean one() : 是否至少有一位是1
// int count() : 返回所有位中1的数量
// String toString() : 返回所有位的状态
public class hw2 {
    // 测试链接 : https://leetcode-cn.com/problems/design-bitset/
    class Bitset {
        public int size;
        // ones 和 zeros 游离于世界之外
        public int ones;
        public int zeros;
        public boolean reverse;
        public int[] set;
        public Bitset(int size) {
            set = new int[(size + 31) / 32];
            ones = 0;
            zeros = size;
            reverse = false;
            this.size = size;
        }

        public void fix(int idx) {
            int index = idx / 32;
            int bit = idx % 32;
            // 0代表不存在， 1代表存在
           if (!reverse) {
               if ((set[index] & (1 << bit)) == 0) {
                   ones++;
                   zeros--;
                   set[index] |= (1 << bit);
               }
           } else {
               // 0代表存在， 1代表不存在
               if ((set[index] & (1 << bit)) != 0) {
                   set[index] &= ~(1 << bit);
                   ones++;
                   zeros--;
               }
           }
        }

        public void unfix(int idx) {
            int index = idx / 32;
            int bit = idx % 32;
            if (!reverse) {
                if ((set[index] & (1 << bit)) != 0) {
                    ones--;
                    zeros++;
                    set[index] ^= (1 << bit);
                }
            } else {
                if ((set[index] & (1 << bit)) == 0) {
                    ones--;
                    zeros++;
                    set[index] |= (1 << bit);
                }
            }
        }

        public void flip() {
            reverse = !reverse;
            int tmp = zeros;
            zeros = ones;
            ones = tmp;

        }

        public boolean all() {
            return ones == size;

        }

        public boolean one() {
            return ones > 0;

        }

        public int count() {
            return ones;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0, k = 0; i < size; k++) {
                int num = set[k];
                for (int j = 0; j < 32  && i < size; j++, i++) {
                    int status = (num >> j) & 1;
                    status ^= reverse ? 1 : 0;
                    sb.append(status);
                }

            }
            return sb.toString();

        }
    }
}
