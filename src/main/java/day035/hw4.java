package day035;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

// 插入、删除和获取随机元素O(1)时间且允许有重复数字的结构
public class hw4 {
    // 测试链接 :
    // https://leetcode.cn/problems/insert-delete-getrandom-o1-duplicates-allowed/
    class RandomizedCollection {
        ArrayList<Integer> arr;
        HashMap<Integer, HashSet<Integer>> map;

        public RandomizedCollection() {
            arr = new ArrayList<>();
            map = new HashMap<>();
        }

        public boolean insert(int val) {
            boolean ans = true;
            int size = arr.size();
            if (map.containsKey(val)) {
                HashSet<Integer> set = map.get(val);
                set.add(size);
                ans = false;
            } else {
                HashSet<Integer> set = new HashSet();
                set.add(size);
                map.put(val, set);
            }
            arr.add(val);
            return ans;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            HashSet<Integer> set = map.get(val);
            int valIndex = set.iterator().next();
            int endValue = arr.get(arr.size() - 1);
            //如果刚好是最后的值，直接删了
            if (val == endValue){
                set.remove(arr.size() - 1);
            } else {
                // 如果不是最后的值，那么需要
                HashSet<Integer> endSet = map.get(endValue);
                endSet.remove(arr.size() - 1);
                endSet.add(valIndex);
                set.remove(valIndex);
                arr.set(valIndex, endValue);
            }
            arr.remove(arr.size() - 1);
            if (set.isEmpty()) {
                map.remove(val);
            }
            return true;

        }

        public int getRandom() {
            return arr.get((int)(Math.random() * arr.size()));

        }
    }
}
