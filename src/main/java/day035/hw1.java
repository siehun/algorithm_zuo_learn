package day035;

import java.util.HashMap;
import java.util.Scanner;
// setAll功能的哈希表
// 测试链接 : https://www.nowcoder.com/practice/7c4559f138e74ceb9ba57d76fd169967
// 请同学们务必参考如下代码中关于输入、输出的处理
// 这是输入输出处理效率很高的写法
// 提交以下的code，提交时请把类名改成"Main"，可以直接通过
public class hw1 {
    public static class Setp {
       public HashMap<Integer, int[]> map;
       public int setTime;
       public int setValue;
       public int cnt;
       public Setp() {
           map = new HashMap<>();
           setTime = -1;
           setValue = 0;
           cnt = 0;
       }
       public void put(int key, int value) {
           map.put(key, new int[]{value, cnt++});
       }
       public int get(int key) {
           if (map.containsKey(key)) {
               int[] record = map.get(key);
               if (record[1] > setTime) {
                   return record[0];
               } else {
                   return setValue;
               }

           } else {
               return -1;
           }
       }
       public void setAll(int value) {
           setValue = value;
           setTime = cnt++;
       }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        Setp s = new Setp();
        for (int i = 0; i < n; i++) {
            int opcode = sc.nextInt();
            if (opcode == 1) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                s.put(a, b);
            } else if (opcode == 2) {
                int a = sc.nextInt();
                int ans = s.get(a);
                System.out.println(ans);
            } else {
                int a = sc.nextInt();
                s.setAll(a);
            }
        }
    }
}
