package day049;

import java.util.HashMap;

public class hw3 {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : tt) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            } else {
                map.put(c, -1);
            }
        }
        int debt = tt.length;
        int start = -1;
        int len = Integer.MAX_VALUE;
        for (int l = 0, r = 0; r < ss.length; r++) {
            char c = ss[r];
            if (map.containsKey(c)) {
                int times = map.get(c);
                if (times >= 0) {
                    map.put(c, times + 1);
                } else {
                    map.put(c, times + 1);
                    debt--;
                }
            } else {
                map.put(c, 1);
            }
            if (debt == 0) {
                while (true) {
                    char d = ss[l];
                    int times = map.get(d);
                    if (times > 0) {
                        map.put(d, times - 1);
                        l++;
                    } else {
                        break;
                    }
                }
                if (len > r - l + 1) {
                    start = l;
                    len = r - l + 1;
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);

    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        hw3 hw = new hw3();
        String ans = hw.minWindow(s,t);
        System.out.println(ans);
    }
}
