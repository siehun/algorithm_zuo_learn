package day047;

// 航班预订统计
// 这里有n个航班，它们分别从 1 到 n 进行编号。
// 有一份航班预订表bookings ，
// 表中第i条预订记录bookings[i] = [firsti, lasti, seatsi]
// 意味着在从 firsti到 lasti
//（包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi个座位。
// 请你返回一个长度为 n 的数组answer，里面的元素是每个航班预定的座位总数。
// 测试链接 : https://leetcode.cn/problems/corporate-flight-bookings/
public class hw1 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] arr = new int[n + 2];
        for (int[] book : bookings) {
            int l = book[0];
            int r = book[1];
            int v = book[2];
            arr[l] += v;
            arr[r + 1] -= v;
        }
        for (int i = 1; i < n + 2; i++) {
            arr[i] = arr[i - 1] + arr[i];
        }
        int[] ans = new int[n];
        for (int i = 1; i <= n; i++) {
            ans[i - 1] = arr[i];
        }
        return ans;
    }
}
