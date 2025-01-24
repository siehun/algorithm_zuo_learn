package day039;
// 含有嵌套的字符串解码
// 测试链接 : https://leetcode.cn/problems/decode-string/
public class hw2 {
    public String decodeString(String s) {
        char[] str = s.toCharArray();
        return f(str, 0);
    }
    public int where = 0;
    public String f(char[] s, int i) {
        StringBuilder builder = new StringBuilder();
        int cur = 0;
        while (i < s.length && s[i] != ']') {
            if (s[i] >= '0' && s[i] <= '9') {
                cur = cur * 10 + (s[i++] - '0');
            } else if (s[i] == '[') {
                String res = f(s, i + 1);
                for (int j = 0; j < cur; j++) {
                    builder.append(res);
                }
                cur = 0;
                i = where + 1;
            } else {
                builder.append(s[i++]);
            }
        }
        where = i;
        return builder.toString();
    }
}
