package day050;


public class hw3 {
    public int trap(int[] height) {
        if(height == null || height.length <= 2) {
            return 0;
        }
        int l = 1;
        int lmax = height[0];
        int r = height.length - 2;
        int rmax = height[r + 1];
        int ans = 0;
        while (l <= r) {
            if (lmax <= rmax) {
                ans += Math.max(0, lmax - height[l]);
                lmax = Math.max(lmax, height[l++]);
            } else {
                ans += Math.max(0, rmax- height[r]);
                rmax = Math.max(rmax, height[r--]);
            }

        }
        return ans;


    }}
