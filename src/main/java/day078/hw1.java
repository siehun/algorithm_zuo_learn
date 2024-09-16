package day078;

import java.util.Scanner;
import java.util.Stack;

public class hw1 {
    // 栈的基本思路，如果是左括号，那么扔栈里面，如果是右括号，那么进行配对
    // 由此延伸， 如果配对不成功，那么个数+1
    // 这是错误的思路，例子([[])在两中括号配对后，栈中为([，来到了),我们知道应该消掉栈内元素[，让()配对
    // 还有一种情况，是 (((])))那么应该消掉栈外元素]
    // 这两种情况无法进行区分
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] s = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        int n =s.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (isleft(s[i])) {
                stack.push(s[i]);
                continue;
            }
            if (stack.isEmpty()) {
                ans++;
            } else if (!istrue(stack.peek(), s[i])) {

            } else {
                stack.pop();
            }
        }
        System.out.println(ans + stack.size());
    }
    public static boolean istrue(char c, char d) {
        return (c == '(' && d == ')') || (c == '[' && d== ']');
    }
    public static boolean isleft(char c) {
        return c == '[' || c == '(';
    }
}
