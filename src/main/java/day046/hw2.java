package day046;

import java.util.HashMap;
import java.util.Scanner;

// 返回无序数组中累加和为给定值的最长子数组长度
// 给定一个无序数组arr, 其中元素可正、可负、可0
// 给定一个整数aim
// 求arr所有子数组中累加和为aim的最长子数组长度
// 测试链接 : https://www.nowcoder.com/practice/36fb0fd3c656480c92b569258a1223d5
public class hw2 {
    // 思路
    // 累计和处理

    // 在以某个数结尾时, 寻找累加和为sum - aim的最长位置
    // 对位置进行记录，注意-1位置的处理
    public static void main(String[] args) {
        // 数据读入
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int aim = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // 哈希表初始化
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        // sum 数组
        int res = 0;
        int[] sum = new int[n];
        for (int i = 0; i < n; i++)  {
            if (i == 0) {
                sum[i] = arr[i];
            } else {
                sum[i] = sum[i - 1] + arr[i];
            }
            if (!map.containsKey(sum[i])) {
                map.put(sum[i], i);
            }
            int temp = sum[i] - aim;
            if (map.containsKey(temp)) {
                res = Math.max(res, i - map.get(temp));
            }
        }
        System.out.println(res);
    }

}
