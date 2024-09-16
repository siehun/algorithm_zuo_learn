package day093;

import java.util.Arrays;

public class hw3 {
    public boolean canConvert(String str1, String str2) {
        if (str1.equals(str2)) {
            return true;
        }
        int[] map = new int[26];
        int kinds = 0;
        for (int i = 0; i < str2.length(); i++) {
            if (map[str2.charAt(i) - 'a']++ == 0) {
                kinds++;
            }
        }
        if (kinds == 26) {
            return false;
        }
        Arrays.fill(map, -1); //map代表字符在上次出现的位置
        for (int i = 0; i < str1.length(); i++) {
            int cur = str1.charAt(i) - 'a';
            if (map[cur] != -1 && str2.charAt(map[cur]) != str2.charAt(i)) {
                return false;
            }
            map[cur] = i;
        }
        return true;


    }
}
