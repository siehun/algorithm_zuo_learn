package day089;

import java.util.ArrayList;
import java.util.Arrays;

public class hw1 {
    public static void main(String[] args) {
        int n = 7; // 字符串个数
        int m = 5; // 字符串长度
        int v = 4; // 字符串的种类
        int testTimes = 1000;
        System.out.println("=======");
        for (int i = 0; i < testTimes; i++) {
            String[] strs = randomStringArray(n, m ,v);
            String ans1 = way1(strs);
            String ans2 = way2(strs);
            if (!ans1.equals(ans2)) {
                System.out.println(ans1 +"   "+ ans2 + "   false!");
            }
        }
        System.out.println("+===");
    }
    public static String way2(String[] strs) {
        Arrays.sort(strs,(a, b) -> (a + b).compareTo(b + a));
        StringBuilder path = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            path.append(strs[i]);
        }
        return path.toString();
    }
    public static void swap(String[] strs, int i, int j) {
        String temp = strs[i];
        strs[i] = strs[j];
        strs[j] = temp;
    }
    public static String way1(String[] strs) {
        ArrayList<String> ans = new ArrayList<>();
        f(strs, 0, ans);
        ans.sort((a, b) -> a.compareTo(b));
        return ans.get(0);

    }
    public static void f(String[] strs, int i, ArrayList<String> ans) {
        if (i == strs.length) {
            StringBuilder builder = new StringBuilder();
            for (String s : strs) {
                builder.append(s);
            }
            ans.add(builder.toString());
        } else {
            for (int j = i; j < strs.length; j++) {
                swap(strs, i, j);
                f(strs, i + 1, ans);
                swap(strs, i, j);
            }
        }

    }
    public static String[] randomStringArray(int n , int m, int v) {
        String[] ans = new String[(int) (Math.random() * n)+ 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = randomString(m, v);
        }
        return ans;
    }
    public static String randomString(int m, int v) {
        int len = (int)(Math.random() * m) + 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            builder.append((char)('a' + (int)(Math.random() * v)));
        }
        return builder.toString();
    }
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs,(a, b) -> (a + b).compareTo(b + a));
        if (strs[0].equals("0")) {
            return "0";
        }
        StringBuilder path = new StringBuilder();
        for (String s : strs) {
            path.append(s);
        }
        return path.toString();

    }
}
