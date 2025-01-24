package day039;

import java.util.ArrayList;

// 含有嵌套的表达式求值
// 测试链接 : https://leetcode.cn/problems/basic-calculator-iii/
public class hw1 {
    public int where = 0;
    public int calculate(String s) {
        char[] str = s.toCharArray();
        int res = f(0, str);
        return res;
    }
    public int f(int i, char[] str) {
        ArrayList<Integer> data = new ArrayList<>();
        ArrayList<Character> op = new ArrayList<>();
        int num = 0;
        while (i < str.length && str[i] != ')') {
            if (str[i] >= '0' && str[i] <= '9') {
                num = num * 10 + (str[i++] - '0');
            } else if (str[i] == '(') {
                num = f(i + 1, str);
                i = where + 1;
            } else {
                push(data, num, op, str[i++]);
                num = 0;
            }
        }
        push(data, num, op, '+');
        where = i;
        int ans = compute(data, op);
        return ans;
    }
    public void push(ArrayList<Integer> data, int num, ArrayList<Character> op, char c) {
        int n = data.size();
        if (n == 0 || op.get(n - 1) == '+' || op.get(n - 1) == '-') {
            data.add(num);
            op.add(c);
        } else {
            int topNumber = data.get(n - 1);
            char topOp = op.get(n - 1);
            if (topOp == '*') {
                data.set(n - 1, topNumber * num);
            } else {
                data.set(n - 1, topNumber / num);
            }
            op.set(n - 1, c);
        }
    }
    public int compute(ArrayList<Integer> data, ArrayList<Character> op) {
        int ans = data.get(0);
        for (int i = 1; i < data.size(); i++) {
            int val = data.get(i);
            if (op.get(i - 1) == '+') {
                ans += val;
            } else {
                ans -= val;
            }
        }
        return ans;
    }
}
