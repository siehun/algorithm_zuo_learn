package day045;

import java.util.ArrayList;
import java.util.List;

// 在二维字符数组中搜索可能的单词
// 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words
// 返回所有二维网格上的单词。单词必须按照字母顺序，通过 相邻的单元格 内的字母构成
// 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格
// 同一个单元格内的字母在一个单词中不允许被重复使用
// 1 <= m, n <= 12
// 1 <= words.length <= 3 * 10^4
// 1 <= words[i].length <= 10
// 测试链接 : https://leetcode.cn/problems/word-search-ii/
public class hw3 {
    public int MAXN = 300001;
    public int[][] record = new int[MAXN][26];
    public int[] pass = new int[MAXN];
    public String[] end = new String[MAXN];
    public int cnt = 1;
    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) {
            insert(word);
        }
        List<String> ans = new ArrayList<>();
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                f(board, i, j, 1, ans);
            }
        }
        return ans;

    }
    public int f(char[][] board, int i, int j, int cur, List<String> ans) {
        int m = board.length;
        int n = board[0].length;
        // 不法位置
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] == '0') {
            return 0;
        }
        // 当前字符是否合格
        char tmp = board[i][j];
        int road = tmp - 'a';
        cur = record[cur][road];
        if (cur == 0 || pass[cur] == 0) {
            return 0;
        }
        // 收集当前字符
        int fix = 0;
        if (end[cur] != null) {
            fix++;
            ans.add(end[cur]);
            end[cur] = null;
        }
        // 后续的收集
        board[i][j] = '0';
        fix += f(board, i - 1, j , cur, ans);
        fix += f(board, i + 1, j , cur, ans);
        fix += f(board, i , j + 1 , cur, ans);
        fix += f(board, i , j - 1 , cur, ans);
        pass[cur] -= fix;
        board[i][j] = tmp;
        return fix;
    }
    public void insert(String word) {
        int cur = 1;
        pass[cur]++;
        for (int i = 0; i < word.length(); i++) {
            int path = word.charAt(i) - 'a';
            if (record[cur][path] == 0) {
                record[cur][path] = ++cnt;
            }
            cur = record[cur][path];
            pass[cur]++;
        }
        end[cur] = word;
    }

}
