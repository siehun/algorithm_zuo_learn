package day067;

public class hw2 {
    public boolean exist(char[][] board, String word) {
        boolean ans = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                 ans |= f(i, j, board, word, 0);
            }
        }
        return ans;
    }
    public boolean f(int i, int j, char[][] board, String word, int cur) {
        if (cur == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(cur)) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '0';
        boolean ans = f(i - 1, j, board, word, cur + 1 ) | f(i + 1, j, board, word, cur + 1) | f(i, j - 1, board, word, cur + 1) | f(i, j + 1, board, word, cur + 1);
        board[i][j] = temp;
        return ans;
    }

}
