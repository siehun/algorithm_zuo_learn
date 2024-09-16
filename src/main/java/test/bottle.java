package test;

public class bottle {
    public static void main(String[] args) {
        int bottle = 1000;
        int ans = f(bottle);
        System.out.println(ans);
    }
    public static int f(int bottle) {
        int ans = 0;
        int empty = 0;
        while (bottle > 0 || empty >= 3) {
            ans += bottle;
            empty += bottle;
            bottle = empty / 3;
            empty = empty % 3;
        }
        System.out.println(bottle);
        System.out.println(empty);
        return ans;
    }
}
