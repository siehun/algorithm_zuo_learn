package day075;

import java.util.Arrays;
import java.util.Scanner;

public class hw5 {
    public static int MAXN = 101;
    public static int MAXM = 100001;
    public static int[] val = new int[MAXN];
    public static int[] cnt = new int[MAXN];
    public static boolean[] dp = new boolean[MAXM];
    public static int n, m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            n = sc.nextInt();
            m = sc.nextInt();
            if (n != 0 || m != 0) {
                for (int i = 1; i <=n ;i++) {
                    val[i] = sc.nextInt();
                }
                for (int i = 1; i <=n ;i++) {
                    cnt[i] = sc.nextInt();
                }
                System.out.println(compute());
            } else {
                break;
            }

        }
    }
    public static int compute() {
        Arrays.fill(dp, 1, m + 1, false);
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            // 01背包问题
            if (cnt[i] == 1) {
                // 数量只有一个
                for (int j = m; j >= val[i]; j--) {
                    if (dp[j - val[i]]) {
                        dp[j] = true;
                    }
                }
            } else if (val[i] * cnt[i] > m) {
                // 完全背包问题
                //   能达到的钱大于m
                for (int j = val[i]; j <= m; j++) {
                    if (dp[j - val[i]]) {
                        dp[j] = true;
                    }
                }
            } else {
                // 多重背包问题
                for (int mod = 0; mod < val[i]; mod++) {
                    int truecnt = 0;
                    for (int j = m - mod, size = 0; j >= 0 && size <= cnt[i]; j-=val[i], size++) {
                        truecnt += dp[j] ? 1 : 0;
                    }
                    for (int j = m - mod, l = j - val[i] * (cnt[i] + 1);j >= 1; j -= val[i], l -=val[i]) {
                        if (dp[i]) {
                            truecnt--;
                        } else {
                            if (truecnt > 0) {
                                dp[j] = true;
                            }
                        }
                        if (l >= 0) {
                            truecnt += dp[l] ? 1 : 0;
                        }
                    }
                }
            }

        }
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            if (dp[i]) {
                ans++;
            }
        }
        return ans;
    }
}
