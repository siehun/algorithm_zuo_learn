package day003;

// 打印一个数的二进制表示
public class hw1 {
    public static void printBinary(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }
    // << 算术左移带符号
    // <<< 逻辑左移不带符号
    public static void main(String[] args) {
        printBinary(10);
    }
}
