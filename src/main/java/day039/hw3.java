package day039;

import java.util.TreeMap;

// 含有嵌套的分子式求原子数量
// 测试链接 : https://leetcode.cn/problems/number-of-atoms/
public class hw3 {
    public String countOfAtoms(String formula) {
        char[] s = formula.toCharArray();
        TreeMap<String, Integer> res= f(s, 0);
        StringBuilder builder = new StringBuilder();
        for (String key : res.keySet()) {
            builder.append(key);
            int cnt = res.get(key);
            if (cnt > 1) {
                builder.append(cnt);
            }
        }
        return builder.toString();
    }
    public int where = 0;
    public TreeMap f(char[] s, int i) {
        TreeMap<String, Integer> res = new TreeMap<>();
        TreeMap<String, Integer> pre = new TreeMap<>();
        StringBuilder builder = new StringBuilder();
        int cnt = 0;
        while (i < s.length && s[i] != ')') {
            if ((s[i] >= 'A' && s[i] <= 'Z') || s[i] == '(') {
                // 结算前面
                fill(res, builder, pre, cnt);
                pre = null;
                cnt = 0;
                builder.setLength(0);
                if (s[i] == '(') {
                     pre = f(s, i + 1);
                    i = where + 1;
                } else {
                    builder.append(s[i++]);
                }
            } else if (s[i] >= '0' && s[i] <= '9') {
                cnt = cnt * 10 + (s[i++] - '0');
            } else {
                builder.append(s[i++]);
            }
        }
        fill(res, builder, pre, cnt);
        where = i;
        return res;
    }
    public  void fill(TreeMap<String, Integer> ans, StringBuilder name, TreeMap<String, Integer> pre, int cnt) {
        if (name.length() > 0 || pre != null) {
            cnt = cnt == 0 ? 1 : cnt;
            if (name.length() > 0) {
                String key = name.toString();
                ans.put(key, ans.getOrDefault(key, 0) + cnt);
            } else {
                for (String key : pre.keySet()) {
                    ans.put(key, ans.getOrDefault(key, 0) + pre.get(key) * cnt);
                }
            }
        }
    }
}
