package day062;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class hw2 {
    public int MAXN = 100001;
    public String[] que = new String[MAXN];
    public int l = 0, r = 0;
    public  HashSet<String> visited = new HashSet<>();
    public int minStickers(String[] stickers, String target) {
        ArrayList<ArrayList<String>> graph = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < stickers.length; i++) {
            stickers[i] = sort(stickers[i]);
        }
        for (int i = 0; i < stickers.length; i++) {
            graph.get(stickers[i].charAt(0) - 'a').add(stickers[i]);
            for (int j  = 1; j < stickers[i].length(); j++) {
                if (stickers[i].charAt(j) != stickers[i].charAt(j - 1)) {
                    graph.get(stickers[i].charAt(j) - 'a').add(stickers[i]);
                }
            }
        }
        target = sort(target);
        visited.add(target);
        que[r++] = target;
        int level = 1;
        while (l < r) {
            int size = r - l;
            for (int i = 0; i < size; i++) {
                String cur = que[l++];
                for (String next : graph.get(cur.charAt(0) - 'a')) {
                    String s = next(next, cur);
                    if (s.equals("")) {
                        return level;
                    } else if(!visited.contains(s)) {
                        visited.add(s);
                        que[r++] = s;
                    }
                }
            }
            level++;
        }
        return -1;



    }
    public String next(String s, String t) {
        StringBuilder builder = new StringBuilder();
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        for (int i = 0, j = 0; i < tt.length;) {
            if (j == s.length()) {
                builder.append(tt[i++]);
            } else {
                if (tt[i] < ss[j]) {
                    builder.append(tt[i++]);
                } else if (tt[i] > ss[j]) {
                    j++;
                } else {
                    i++;
                    j++;
                }
            }
        }
        return builder.toString();
    }
    // 对一个字符串进行排序，返回一个字符串
    public String sort(String cur) {
        char[] tmp = cur.toCharArray();
        Arrays.sort(tmp);
        return String.valueOf(tmp);
    }
}
