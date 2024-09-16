package day071;
// 删掉1个数字后长度为k的子数组最大累加和
// 给定一个数组nums，求必须删除一个数字后的新数组中
// 长度为k的子数组最大累加和，删除哪个数字随意
// 对数器验证
public class hw6 {
    public static int maxSum1(int[] nums, int k) {
        int n = nums.length;
        if (n <= k) {
            return 0;
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int[] rest = delete(nums, i);
            ans = Math.max(ans, lenKmaxSum(rest, k));
        }
        return ans;
    }

    public static int lenKmaxSum(int[] nums, int k) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i <= n - k; i++) {
            int cur = 0;
            for (int j = i, cnt = 0; cnt < k; j++, cnt++) {
                cur += nums[j];
            }
            ans = Math.max(ans, cur);
        }
        return ans;
    }


    public static int[] delete(int[] nums, int index) {
        int len = nums.length - 1;
        int[] ans = new int[len];
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (j != index) {
                ans[i++] = nums[j];
            }
        }
        return ans;
    }
    public static int maxSum2(int[] nums, int k) {
        int n = nums.length;
        if (n <= k) {
            return 0;
        }
        int[] window = new int[n];
        int l = 0;
        int r = 0;
        long sum = 0;
        int ans =  Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            while (l < r && nums[window[r - 1]] >= nums[i]) {
                r--;
            }
            window[r++] = i;
            sum += nums[i];
            if (i >= k) {
                ans = Math.max(ans, (int) (sum - nums[window[l]]));
                if (window[l] == i - k) {
                    l++;
                }
                sum -= nums[i - k];
            }
        }
        return ans;
    }
    // 为了测试
    // 生成长度为n，值在[-v, +v]之间的随机数组
    public static int[] randomArray(int n, int v) {
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = (int) (Math.random() * (2 * v + 1)) - v;
        }
        return ans;
    }

    // 为了测试
    // 对数器
    public static void main(String[] args) {
        int n = 200;
        int v = 1000;
        int testTimes = 10000;
        System.out.println("测试开始");
        for (int i = 0; i < testTimes; i++) {
            int len = (int) (Math.random() * n) + 1;
            int[] nums = randomArray(len, v);
            int k = (int) (Math.random() * n) + 1;
            int ans1 = maxSum1(nums, k);
            int ans2 = maxSum2(nums, k);
            if (ans1 != ans2) {
                System.out.println("出错了!");
            }
        }
        System.out.println("测试结束");
    }
}
