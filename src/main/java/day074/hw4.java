package day074;

public class hw4 {
    // 正则表达式匹配
    // s 字符串， t 字符串
    // *让前面的字符任意, .可以是任意字符
    public boolean isMatch(String str, String pat) {
        char[] s = str.toCharArray();
        char[] p = pat.toCharArray();
        return f1(s, p, 0, 0);
    }
    public boolean f1(char[] s, char[] p, int i, int j) {
        // 匹配到s[i], p[j]
        if (i == s.length) {
            if (j == p.length) {
                return true;
            } else {
                return j + 1 < p.length && p[j + 1] == '*' && f1(s, p, i, j + 2);
            }
        } else if (j == p.length) {
            return false;
        } else {
            // s, p 都还有
            // 对j + 1是否为*进行区别
            // 我们通过限制让j位置不会为*
            if (j + 1 == p.length || p[j + 1] != '*') {
                return (s[i] == p[j] || p[j] == '.') && f1(s, p, i + 1, j + 1);
            } else {
                // 搞成0个
                boolean p1 = f1(s, p, i, j + 2);
                // 先搞再说
                boolean p2= (s[i] == p[j] || p[j] == '.') && f1(s, p, i + 1, j);
                return p1 || p2;
            }
        }
    }

    public static void main(String[] args) {
        hw4 hw = new hw4();
        boolean b = hw.isMatch("ab", ".*..");
        System.out.println(b);
    }
}
