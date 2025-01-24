package day049;

import java.util.HashMap;

// 无重复字符的最长子串
// 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
// 测试链接 : https://leetcode.cn/problems/longest-substring-without-repeating-characters/
public class hw2 {
    public int lengthOfLongestSubstring(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;
        for (int l = 0, r = 0; r < n; r++) {
            char c = str[r];
            if (map.containsKey(c)) {
                l = Math.max(l, map.get(c) + 1);
            }
            ans = Math.max(ans, r - l + 1);
            map.put(c, r);
        }
        return ans;
    }
}
