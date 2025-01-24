package day043;

import java.util.Scanner;

// 现在有一个打怪类型的游戏，这个游戏是这样的，你有n个技能
// 每一个技能会有一个伤害，
// 同时若怪物小于等于一定的血量，则该技能可能造成双倍伤害
// 每一个技能最多只能释放一次，已知怪物有m点血量
// 现在想问你最少用几个技能能消灭掉他(血量小于等于0)
// 技能的数量是n，怪物的血量是m
// i号技能的伤害是x[i]，i号技能触发双倍伤害的血量最小值是y[i]
// 1 <= n <= 10
// 1 <= m、x[i]、y[i] <= 10^6
// 测试链接 : https://www.nowcoder.com/practice/d88ef50f8dab4850be8cd4b95514bbbd
// 请同学们务必参考如下代码中关于输入、输出的处理
// 这是输入输出处理效率很高的写法
// 提交以下的所有代码，并把主类名改成"Main"
// 可以直接通过
public class hw1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 次数
        int times = sc.nextInt();
        for (int time = 0; time < times; time++) {
            // 技能数
            int skill = sc.nextInt();
            // 血量
            int blood = sc.nextInt();
            // 伤害
            int[] record = new int[skill];
            // 阈值
            int[] dou = new int[skill];
            for (int i = 0; i < skill; i++) {
                record[i] = sc.nextInt();
                dou[i] = sc.nextInt();
            }
            int ans = f(skill,0, blood, dou, record);
            System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
        }
    }
    public static int f(int skill, int i, int blood, int[] dou, int[] record) {
        if (blood <= 0) {
            return i;
        }
        if (i == skill) {
            return Integer.MAX_VALUE;
        }
        int ans = Integer.MAX_VALUE;
        for (int j = i; j < skill; j++) {
            swap(record, dou, i, j);
            int restblood = blood - (dou[i] >= blood ? record[i] * 2 : record[i]);
            ans = Math.min(ans,f(skill, i + 1, restblood, dou, record));
            swap(record, dou, i, j);
        }
        return ans;
    }
    public static void swap(int[] arr, int[] dou, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        int tmp = dou[i];
        dou[i] = dou[j];
        dou[j] = tmp;
    }
}
