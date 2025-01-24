package day044;

import java.util.Arrays;
import java.util.Scanner;

// 用固定数组实现前缀树，空间使用是静态的。推荐！
// 测试链接 : https://www.nowcoder.com/practice/7f8a8553ddbf4eaab749ec988726702b
// 请同学们务必参考如下代码中关于输入、输出的处理
// 这是输入输出处理效率很高的写法
// 提交以下的code，提交时请把类名改成"Main"，可以直接通过
public class hw2 {
    public static int MAXN = 1000000;
    public static int[][] record = new int[MAXN][26];
    public static int[] end = new int[MAXN];
    public static int[] pass = new int[MAXN];
    public static int cnt = 1;
    public static void insert(String word) {
        int cur = 1;
        pass[cur]++;
        for (int i = 0; i < word.length(); i++) {
            int path = word.charAt(i) - 'a';
            if (record[cur][path] == 0) {
                record[cur][path] = ++cnt;
            }
            cur = record[cur][path];
            pass[cur]++;
        }
        end[cur]++;
    }
    public static void delete(String word) {
        if (search(word)) {
            int cur = 1;
            pass[cur]--;
            for (int i = 0; i < word.length(); i++) {
                int path = word.charAt(i) - 'a';
                if (--pass[record[cur][path]] == 0) {
                    record[cur][path] = 0;
                    return;
                }
                cur = record[cur][path];
            }
            end[cur]--;
        }
    }
    public static boolean search(String word) {
        int cur = 1;
        for (int i = 0; i < word.length(); i++) {
            int path = word.charAt(i) - 'a';
            if (record[cur][path] == 0) {
                return false;
            }
            cur = record[cur][path];
        }
        return end[cur] != 0;
    }
    public static int prefixNumber(String pre) {
        int cur = 1;
        for (int i = 0; i < pre.length(); i++) {
            int path = pre.charAt(i) - 'a';
            if (record[cur][path] == 0) {
                return 0;
            }
            cur = record[cur][path];
        }
        return pass[cur];

    }
    public static void earse() {
        for (int i = 1; i <= cnt; i++) {
            Arrays.fill(record[i], 0);
            end[i] = 0;
            pass[i] = 0;
        }
        cnt = 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int opt = sc.nextInt();
            if (opt == 1) {
                String s = sc.next();
                insert(s);
            } else if (opt == 2) {
                String s = sc.next();
                delete(s);
            } else if (opt == 3) {
                String s = sc.next();
                boolean res = search(s);
                System.out.println(res ? "YES" : "NO");
            } else if (opt == 4) {
                String s = sc.next();
                int num = prefixNumber(s);
                System.out.println(num);
            }
        }
        earse();
    }
}
