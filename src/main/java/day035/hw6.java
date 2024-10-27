package day035;

import java.util.ArrayList;
import java.util.HashMap;

// 最大频率栈
public class hw6 {
    // 测试链接 : https://leetcode.cn/problems/maximum-frequency-stack/
    class FreqStack {
        private int topTimes;
        private HashMap<Integer, ArrayList<Integer>> cntValues = new HashMap<>();
        private HashMap<Integer, Integer> valuesTimes = new HashMap<>();
        public FreqStack() {

        }

        public void push(int val) {
            // 加入进去无非更新两个哈希表和topTimes
            int curTimes = valuesTimes.getOrDefault(val, 0) + 1;
            valuesTimes.put(val, curTimes);
            if (!cntValues.containsKey(curTimes)) {
                cntValues.put(curTimes, new ArrayList<>());
            }
            cntValues.get(curTimes).add(val);
            topTimes = Math.max(curTimes, topTimes);
        }

        public int pop() {
            ArrayList<Integer> list = cntValues.get(topTimes);
            int ans = list.remove(list.size() - 1);
            if (list.size() == 0) {
                cntValues.remove(topTimes);
                topTimes--;
            }
            int times = valuesTimes.get(ans);
            if (times == 1) {
                valuesTimes.remove(ans);
            } else{
                valuesTimes.put(ans, times - 1);
            }
            return ans;
        }
    }
}
