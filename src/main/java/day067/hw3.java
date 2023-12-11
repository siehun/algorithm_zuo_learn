package day067;

public class hw3 {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] chr1, chr2;
        if (text1.length() > text2.length()) {
             chr1 = text1.toCharArray();
             chr2 = text2.toCharArray();
        } else {
            chr1 = text2.toCharArray();
            chr2 = text1.toCharArray();
        }
        int n = chr1.length;
        int m = chr2.length;
        int[] record = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            int leftup = 0, backup;
            for (int j = 1; j <= n; j++) {
                backup = record[j];
                if (chr2[i - 1] == chr1[j - 1]) {
                    record[j] = leftup + 1;
                } else {
                    record[j] = Math.max(record[j - 1], record[j]);
                }
                leftup = backup;
            }
        }
        return record[n];
    }
    public int f1(char[] chr1, char[] chr2, int i, int j) {
        if (i == 0 || j == 0) {
            return 0;
        }
        if (chr1[i - 1] == chr2[j - 1]) {
            return f1(chr1, chr2, i - 1, j - 1) + 1;
        } else {
            return Math.max(f1(chr1, chr2, i, j - 1), f1(chr1, chr2, i - 1, j));
        }
    }
}
