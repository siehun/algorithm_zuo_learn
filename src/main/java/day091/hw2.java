package day091;

import java.util.List;
import java.util.TreeSet;

public class hw2 {
    public static class Node {
        // 值
        public int val;
        // 在那个数组中
        public int far;
        // 位置
        public int index;
        public Node(int v, int f, int i) {
            val = v;
            far = f;
            index = i;
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        TreeSet<Node> set = new TreeSet<>((a, b) -> a.val != b.val ? (a.val - b.val) : (a.far - b.far));
        int k = nums.size();
        for (int i = 0; i < k; i++) {
            int val = nums.get(i).get(0);
            set.add(new Node(val, i, 0));
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int dis = Integer.MAX_VALUE;
        while (set.size() == k) {
            Node last = set.last();
            Node first = set.pollFirst();
            if (last.val - first.val < dis) {
                dis = last.val - first.val;
                min = first.val;
                max = last.val;
            }
            if (first.index + 1 < nums.get(first.far).size()) {
                set.add(new Node(nums.get(first.far).get(first.index + 1), first.far,first.index + 1));
            }
        }
        return new int[] {min, max};

    }
}
