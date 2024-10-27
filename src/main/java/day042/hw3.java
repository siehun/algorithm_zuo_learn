package day042;
// 判断一个数字是否是若干数量(数量>1)的连续正整数的和
public class hw3 {
    public static void main(String[] args) {
        for (int i = 1; i < 200; i++) {
            System.out.println(i + ": " + (is2(i) ? "T" :"F"));
        }
    }
    public static boolean is1(int num) {
        //每个数字都试一遍
        for (int i = 1; i < num; i++) {
            int sum = 0;
            for(int j = i; sum <= num; sum += j, j++) {
                if (sum == num) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean is2(int num) {
        return (num & (num - 1)) != 0;
    }
}
