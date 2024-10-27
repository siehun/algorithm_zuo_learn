package day035;

import java.util.ArrayList;
import java.util.HashMap;
// 插入、删除和获取随机元素O(1)时间的结构
public class hw3 {
    // 测试链接 : https://leetcode.cn/problems/insert-delete-getrandom-o1/
    class RandomizedSet {
        private ArrayList<Integer> set;
        private HashMap<Integer, Integer> map;
        public RandomizedSet() {
            set = new ArrayList<>();
            map = new HashMap<>();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            set.add(val);
            map.put(val, set.size() - 1);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            int valIndex = map.get(val);
            int endValue = set.get(set.size() - 1);
            map.put(endValue, valIndex);
            set.set(valIndex, endValue);
            map.remove(val);
            set.remove(set.size() - 1);
            return true;
        }

        public int getRandom() {
            return set.get((int)(Math.random() * set.size()));
        }
    }
}
