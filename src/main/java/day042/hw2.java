package day042;
// 草一共有n的重量，两只牛轮流吃草，A牛先吃，B牛后吃
// 每只牛在自己的回合，吃草的重量必须是4的幂，1、4、16、64....
// 谁在自己的回合正好把草吃完谁赢，根据输入的n，返回谁赢
public class hw2 {
    public static void main(String[] args) {
        for (int i = 0; i <= 50; i++) {
            System.out.println(i+": " + win1(i));
        }
    }
    public static String win1(int n) {
        return f(n, "A");
    }
    public static String f(int rest, String cur) {
        String enemy = cur.equals("A") ?  "B" : "A";
        if (rest == 0) {
            return enemy;
        }
        for (int pick = 1; pick <= rest; pick *= 4) {
            if (f(rest - pick, enemy).equals(cur)) {
                return cur;
            }
        }
        return enemy;
    }


}
