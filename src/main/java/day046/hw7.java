package day046;

import java.util.Arrays;

// 每个元音包含偶数次的最长子字符串
// 给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度
// 每个元音字母，即 'a'，'e'，'i'，'o'，'u'
// 在子字符串中都恰好出现了偶数次。
// 测试链接 : https://leetcode.cn/problems/find-the-longest-substring-containing-vowels-in-even-counts/
public class hw7 {
    public int findTheLongestSubstring(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        int[] record = new int[32];
        Arrays.fill(record, -2);
        // 状态对应的最早位置
        record[0] = -1;
        // 状态的记录
        int flag = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int num = aeiou(str[i]);
            if (num != -1) {
                flag ^= 1 << num;
            }
            if (record[flag] != -2) {
                ans = Math.max(ans, i - record[flag]);
            } else {
                record[flag] = i;
            }
        }
        return ans;
    }
    public int aeiou(char c) {
        if (c == 'a') {
            return 4;
        } else if (c == 'e') {
            return 3;
        } else if (c == 'i') {
            return 2;
        } else if (c == 'o') {
            return 1;
        } else if (c == 'u') {
            return 0;
        } else {
            return -1;
        }
    }
}
