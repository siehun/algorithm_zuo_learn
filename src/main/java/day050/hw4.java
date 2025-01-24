package day050;

import java.util.Arrays;

// 救生艇
// 给定数组 people
// people[i]表示第 i 个人的体重 ，船的数量不限，每艘船可以承载的最大重量为 limit
// 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit
// 返回 承载所有人所需的最小船数
// 测试链接 : https://leetcode.cn/problems/boats-to-save-people/
public class hw4 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n  = people.length;
        int l = 0, r = n - 1;
        int ans = 0;
        while (l <= r) {
            if (l == r) {
                ans++;
                break;
            }
            ans++;
            if (people[l] + people[r] > limit) {
                r--;
            } else {
                l++; r--;
            }
        }
        return ans;

    }

}
