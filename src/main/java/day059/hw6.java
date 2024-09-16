package day059;

import java.util.ArrayList;
import java.util.Arrays;

public class hw6 {
    public String alienOrder(String[] words) {
        int[] degree = new int[26];
        Arrays.fill(degree, -1);
        // 把所以出现的字符标记出来
        for (String w : words) {
            for (int i = 0; i < w.length(); i++) {
                degree[w.charAt(i) - 'a'] = 0;
            }
        }
        // 图的准备
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }
        // 建图及判断过程
        for (int i = 0; i < words.length - 1; i++) {
            String cur = words[i];
            String next = words[i + 1];
            int len = Math.min(cur.length(), next.length());
            int j = 0;
            for (;j < len; j++) {
                if (cur.charAt(j) != next.charAt(j)) {
                    graph.get(cur.charAt(j) - 'a').add(next.charAt(j) - 'a');
                    degree[next.charAt(j) - 'a']++;
                    break;
                }
            }
            if (j < cur.length() && j == next.length()) {
                return "";
            }
        }
        int kinds = 0;
        int[] queue = new int[26];
        int l = 0, r = 0;
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue[r++] = i;
            }
            if (degree[i] != -1) {
                kinds++;
            }
        }
        StringBuilder builder = new StringBuilder();
        while (l < r) {
            int cur = queue[l++];
            char ans = (char) (cur + 'a');
            builder.append(ans);
            for (int i : graph.get(cur)) {
                if (--degree[i] == 0) {
                    queue[r++] = i;
                }
            }
        }
        return builder.length() == kinds ? builder.toString() : "";


    }
}
