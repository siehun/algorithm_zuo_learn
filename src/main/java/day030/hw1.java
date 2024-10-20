package day030;
// 异或运算交换两数的值
public class hw1 {
    public static void main(String[] args) {
        int a = 10;
        int b= 2;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }
    // 当i == j时，就会出现问题
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j]; // a = a ^ b
        arr[j] = arr[i] ^ arr[j]; // b = (a ^ b) ^ b = a
        arr[i] = arr[i] ^ arr[j]; // a = (a ^ b) ^ a = b
    }
}
