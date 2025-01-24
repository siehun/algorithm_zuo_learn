package day049;
// 替换子串得到平衡字符串
// 有一个只含有 'Q', 'W', 'E', 'R' 四种字符，且长度为 n 的字符串。
// 假如在该字符串中，这四个字符都恰好出现 n/4 次，那么它就是一个「平衡字符串」。
// 给你一个这样的字符串 s，请通过「替换一个子串」的方式，使原字符串 s 变成一个「平衡字符串」。
// 你可以用和「待替换子串」长度相同的 任何 其他字符串来完成替换。
// 请返回待替换子串的最小可能长度。
// 如果原字符串自身就是一个平衡字符串，则返回 0。
// 测试链接 : https://leetcode.cn/problems/replace-the-substring-for-balanced-string/
public class hw5 {
    public static int balancedString(String str) {
        int n = str.length();
        char[] arr = str.toCharArray();
        int target = n / 4;
        int[] count = new int[4];
        int[] debt = new int[4];
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            char a = arr[i];
            count[f(a)]++;
        }
        int deb = 0;
        for (int i = 0 ; i <4; i++) {
            int cur = count[i] - target;
            if (cur > 0) {
                debt[i] = cur;
                deb += debt[i];
            }
        }
        for (int l = 0, r = 0; r < n && l < n; r++) {
            char ch = arr[r];
            if (debt[f(ch)] > 0) {
                deb--;
                debt[f(ch)]--;
            }
            if (deb == 0) {
                while(true) {
                    char ll = arr[l];
                    if (debt[f(ll)] < 0) {
                        l++;
                        debt[f(ll)]++;
                    } else {
                        break;
                    }
                }
                len = Math.min(len, r -l + 1);
            }
        }
        return len;
    }
    public static int f(char c) {
        if (c == 'Q') {
            return 0;
        } else if (c == 'W') {
            return 1;
        } else if (c == 'E') {
            return 2;
        } else {
            return 3;
        }
    }

}
