package day038;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// 字符串的全部子序列
// 子序列本身是可以有重复的，只是这个题目要求去重
// 测试链接 : https://www.nowcoder.com/practice/92e6247998294f2c933906fdedbc6e6a
public class hw1 {
    public String[] generatePermutation1 (String s) {
        // write code here
        char[] chr = s.toCharArray();
        int n = chr.length;
        HashSet<String> set = new HashSet<>();
        char[] path = new char[n];
        f(chr, 0, path, 0  , set);
        int m = set.size();
        String[] ans = new String[m];
        int i = 0;
        for (String cur : set) {
            ans[i++] = cur;
        }
        return ans;
    }
    public void f(char[] chr, int i, char[] path,  int size, HashSet<String> set) {
        if (i == chr.length) {
            set.add(String.valueOf(path,0, size));
        } else {
            path[size] = chr[i];
            f(chr, i + 1, path,size + 1, set);
            f(chr, i + 1, path,size, set);
        }
    }
    public String[] generatePermutation (String s) {
        char[] chr = s.toCharArray();
        int n = chr.length;
        HashSet<String> set = new HashSet<>();
        f1(chr, 0, new StringBuilder(), set);
        int m = set.size();
        String[] ans = new String[m];
        int i = 0;
        for (String cur : set) {
            ans[i++] = cur;
        }
        return ans;
    }
    public void f1(char[] chr, int i, StringBuilder sb, HashSet<String> set) {
        if (i == chr.length) {
            set.add(sb.toString());
        } else {
            f1(chr, i + 1, sb, set);
            sb.append(chr[i]);
            f1(chr, i + 1, sb, set);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
