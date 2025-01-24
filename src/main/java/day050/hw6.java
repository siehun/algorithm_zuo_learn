package day050;

import java.util.Arrays;

// 供暖器
// 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
// 在加热器的加热半径范围内的每个房屋都可以获得供暖。
// 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置
// 请你找出并返回可以覆盖所有房屋的最小加热半径。
// 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。
// 测试链接 : https://leetcode.cn/problems/heaters/
public class hw6 {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans = 0;
        int ho = 0, ht = 0;
        while (ho < houses.length && ht < heaters.length) {
            if (best(houses, heaters, ho, ht)) {
                ans = Math.max(ans, Math.abs(houses[ho] - heaters[ht]));
                ho++;
            } else{
                ht++;
            }
        }
        return ans;
    }
    public boolean best(int[] houses, int[] heaters, int ho, int ht) {
        if (ht == heaters.length - 1) {
            return true;
        }
        int cut1 = Math.abs(houses[ho] - heaters[ht]);
        int cut2 = Math.abs(houses[ho] - heaters[ht + 1]);
        return cut1 < cut2;
    }
}
