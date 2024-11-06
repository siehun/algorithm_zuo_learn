package day038;

import java.util.Stack;

// 用递归函数逆序栈
public class hw5 {
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int res = bottomOut(stack);
        reverse(stack);
        stack.push(res);
    }

    // 栈底元素移除掉，上面的元素盖下来
    // 返回移除掉的栈底元素
    public static int bottomOut(Stack<Integer> stack) {
        // 先弹出来，在加进去
        // 如果是最后一个，别加了，直接返回给上级
        int ans = stack.pop();
        if (stack.isEmpty()) {
            return ans;
        } else {
            // 结果要层层返回，要拿递归值
            int last = bottomOut(stack);
            stack.push(ans);
            return last;
        }
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        reverse(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
