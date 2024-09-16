package day093;

public class hw1 {
    public int jump(int[] nums) {
        int cur = 0;// 当前能跳多远
        int next = 0;// 下一步能跳多远
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (cur < i) {// 当前步已经跳不动了
                ans++;
                cur = next;//步数加一
            }
            next = Math.max(next, i + nums[i]);
        }
        return ans;
    }
}
